package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto;

import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private String name;
    private String email;

    public static UserDTO from(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}