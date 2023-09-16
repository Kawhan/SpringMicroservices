package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto;

import br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.enums.RoleUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
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
}
