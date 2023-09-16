package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.dto;

import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.entity.User;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.enums.RoleUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
@Setter
public class UserRequestParcialDTO {
    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("email")
    @NotNull
    private String email;

    @JsonProperty("roleUser")
    @NotNull
    private RoleUser roleUser;

    @JsonProperty("authID")
    @NotNull
    private long authID;

    public static UserRequestParcialDTO from(User user) {
        return UserRequestParcialDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .roleUser(user.getRoleUser())
                .authID(user.getId())
                .build();
    }
}
