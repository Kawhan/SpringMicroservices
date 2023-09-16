package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OpportunityAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpportunityAuthApplication.class, args);
    }

}
