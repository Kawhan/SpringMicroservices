package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob;

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
public class OpportunityJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpportunityJobApplication.class, args);
    }

}
