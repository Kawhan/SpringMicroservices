package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.service;


import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto.JobRequestDTO;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto.JobResponseDTO;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto.JobResponseInterestedUsersDTO;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto.JobTitleRequestDTO;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto.TokenRequestDTO;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto.UserRequestDTO;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto.UserResponseDTO;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.entity.Job;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.entity.User;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.enums.RoleUser;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.enums.TypeJob;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception.NotAuthorizedException;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception.NotFoundJobException;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception.NotFoundUserException;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception.UserAlreadyExistsException;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.mappers.JobMapper;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.repository.AuthClient;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.repository.JobRepository;
import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final JobMapper jobMapper;
    private final AuthClient authClient;

    public List<JobResponseDTO> getAllJobs() {
        return JobResponseDTO.fromAll(jobRepository.findAll());
    }

    public List<JobResponseDTO> getAllInterestsFromUser(String header) {
        User userLogged = this.getUser(authClient.getAuthToke(header));

        return JobResponseDTO.fromAll(jobRepository.findJobsByUserIdInterested(userLogged.getId()));
    }

    public JobResponseDTO createJob(JobRequestDTO jobRequestDTO, String header) {
        User userLogged = this.getUser(authClient.getAuthToke(header));

        if (userLogged.getRoleUser().equals(RoleUser.PROFESSOR)) {
            Job newJob = new Job(
                    jobRequestDTO.getNumberVacancies(),
                    jobRequestDTO.getHoursWeek(),
                    jobRequestDTO.getScholarshipValue(),
                    jobRequestDTO.getOpeningDate(),
                    jobRequestDTO.getBenefits(),
                    jobRequestDTO.getTitleJob(),
                    jobRequestDTO.getPdfLink(),
                    jobRequestDTO.getClosingDate(),
                    userLogged,
                    jobRequestDTO.getTypeJob(),
                    jobRequestDTO.getNameProject(),
                    jobRequestDTO.getLinkJob()
            );
            Job job = jobRepository.save(newJob);
            return JobResponseDTO.from(job);
        } else throw new NotAuthorizedException();
    }

    public JobResponseInterestedUsersDTO realizeInterest(Long id, String header) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isEmpty()) {
            throw new NotFoundJobException();
        }

        User userLogged = this.getUser(authClient.getAuthToke(header));

        if (userLogged.getRoleUser().equals(RoleUser.STUDENT)) {
            if (job.get().userInterested(userLogged)) {
                job.get().removeUserInterested(userLogged);
                job.get().removeInterest();
                return JobResponseInterestedUsersDTO.from(jobRepository.save(job.get()));
            }
            job.get().addUserInterested(userLogged);
            job.get().addInterest();
            return JobResponseInterestedUsersDTO.from(jobRepository.save(job.get()));
        } else throw new NotAuthorizedException();
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        Optional<User> userFound = userRepository.findByEmail(userRequestDTO.getEmail());

        if (userFound.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        User newUser = new User(
                userRequestDTO.getEmail(),
                userRequestDTO.getName(),
                userRequestDTO.getRoleUser(),
                userRequestDTO.getAuthID()
        );
        User user = userRepository.save(newUser);
        return UserResponseDTO.from(user);
    }

    public JobResponseDTO getJob(long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isEmpty()) {
            throw new NotFoundJobException();
        }
        return JobResponseDTO.from(job.get());
    }

    public List<JobResponseDTO> getJobByTitleJob(String titleJob) {
        return JobResponseDTO.fromAll(jobRepository.findByTitleJobStartingWith(titleJob));
    }

    public List<JobResponseDTO> getJobsByTypeJob(TypeJob typeJob) {
        return JobResponseDTO.fromAll(jobRepository.findByTypeJob(typeJob));
    }

    public JobResponseDTO changeInfoJob(long id, JobRequestDTO jobRequestDTO, String header) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isEmpty()) {
            throw new NotFoundJobException();
        }

        User userLogged = this.getUser(authClient.getAuthToke(header));

        if (userLogged.getRoleUser().equals(RoleUser.PROFESSOR) && job.get().getUserCreator().equals(userLogged)) {
            Job updateJob = jobMapper.updateJobFromDto(jobRequestDTO, job.get());
            updateJob.setUserCreator(userLogged);
            jobRepository.save(updateJob);
            return JobResponseDTO.from(job.get());
        } else throw new NotAuthorizedException();
    }

    public JobResponseDTO changeTitleJob(long id, JobTitleRequestDTO jobTitleRequestDTO, String header) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isEmpty()) {
            throw new NotFoundJobException();
        }

        User userLogged = this.getUser(authClient.getAuthToke(header));

        if (userLogged.getRoleUser().equals(RoleUser.PROFESSOR) && job.get().getUserCreator().equals(userLogged)) {
            job.get().setTitleJob(jobTitleRequestDTO.getTitleJob());
            jobRepository.save(job.get());
            return JobResponseDTO.from(job.get());
        } else throw new NotAuthorizedException();
    }

    public JobResponseDTO deleteJob(long id, String header) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isEmpty()) {
            throw new NotFoundJobException();
        }

        User userLogged = this.getUser(authClient.getAuthToke(header));

        if (userLogged.getRoleUser().equals(RoleUser.PROFESSOR) && job.get().getUserCreator().equals(userLogged)) {
            jobRepository.delete(job.get());
            return JobResponseDTO.from(job.get());
        } else throw new NotAuthorizedException();


    }



    // Users methods

    private User getUser(String email) {
        Optional<User> userFound = userRepository.findByEmail(email);
        if (!userFound.isEmpty()) {
            return userFound.get();
        }
        throw new NotFoundUserException();
    }
}
