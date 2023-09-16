package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.services;


import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.dto.LoginUserDTO;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.dto.UserRequestDTO;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.dto.UserResponseDTO;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.entity.User;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.enums.RoleUser;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.exception.NotAuthorizedException;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.exception.NotFoundUserException;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.exception.UserAlreadyExistsException;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTService jwtService;

    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        Optional<User> userFound = userRepository.findByEmail(userRequestDTO.getEmail());

        if (userFound.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        User newUser = new User(
                userRequestDTO.getEmail(),
                userRequestDTO.getName(),
                userRequestDTO.getPassword(),
                userRequestDTO.getRoleUser()
        );
        User user = userRepository.save(newUser);
        return UserResponseDTO.from(user);
    }

    private User getUser(String email) {
        Optional<User> userFound = userRepository.findByEmail(email);
        if (!userFound.isEmpty()) {
            return userFound.get();
        }
        throw new NotFoundUserException();
    }

    public UserResponseDTO getUserByEmail(String email, String authHeader) {
        Optional<User> userFound = userRepository.findByEmail(email);
        if (!userFound.isEmpty() && userHasPermission(authHeader, email)) {
            return UserResponseDTO.from(userFound.get());
        }
        throw new NotAuthorizedException();
    }

    public boolean validateUserPassword(LoginUserDTO user) {
        Optional<User> userFound = userRepository.findByEmail(user.getEmail());
        if (userFound.isPresent() && userFound.get().getPassword().equals(user.getPassword()))
            return true;
        return false;
    }

    protected boolean userHasPermission(String authorizationHeader, String email) {
        String subject = jwtService.getTokenSubject(authorizationHeader);
        Optional<User> userFound = userRepository.findByEmail(subject);
        return (userFound.isPresent() && userFound.get().getEmail().equals(email)) || userFound.get().getRoleUser().equals(RoleUser.PROFESSOR) ;
    }

    public UserResponseDTO removeUser(String email, String authHeader) {
        User userToBeDeleted = this.getUser(email);
        User userLogged = this.getUser(jwtService.getTokenSubject(authHeader));
        if(userLogged.getRoleUser().equals(RoleUser.PROFESSOR) ||
                userLogged.getEmail().equals(userToBeDeleted.getEmail()))
            userRepository.delete(userToBeDeleted);
        else  throw new NotAuthorizedException();
        return UserResponseDTO.from(userToBeDeleted);
    }

}
