package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto;


import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.entity.User;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.enums.RoleUser;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class UserResponseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String name;
    String email;
    RoleUser roleUser;

    public static UserResponseDTO from(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .roleUser(user.getRoleUser())
                .build();
    }

    public static List<UserResponseDTO> fromAll(List<User> listOfUser) {
        return listOfUser.stream().map(UserResponseDTO::from).toList();
    }
}
