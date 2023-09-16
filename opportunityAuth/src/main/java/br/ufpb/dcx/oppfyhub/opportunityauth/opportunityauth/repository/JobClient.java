package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.repository;

import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.dto.UserRequestParcialDTO;
import br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.dto.UserResponseParcialDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("OPPORTUNITY-JOB")
public interface JobClient {
    @GetMapping("/v1/api/jobs/createUser")
    UserResponseParcialDTO createUserJobClient(@RequestHeader UserRequestParcialDTO userRequestParcialDTO);
}
