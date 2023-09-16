package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.repository;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("OPPORTUNITY-AUTH")
public interface AuthClient {

    @GetMapping("/auth/getToken")
    String getAuthToke(@RequestHeader("Authorization") String bearerToken);
}
