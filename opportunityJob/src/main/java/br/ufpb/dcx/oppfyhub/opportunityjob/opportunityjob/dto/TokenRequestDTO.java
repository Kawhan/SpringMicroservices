package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class TokenRequestDTO {
    @JsonProperty("token")
    @NotNull
    private String token;

    public static TokenRequestDTO from(String token) {
        return TokenRequestDTO.builder()
                .token(token)
                .build();
    }
}
