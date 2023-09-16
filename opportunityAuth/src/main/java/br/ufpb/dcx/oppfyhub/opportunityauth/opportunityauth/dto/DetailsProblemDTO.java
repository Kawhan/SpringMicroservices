package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class DetailsProblemDTO {
    private int status;
    private String type;
    private String title;
    private String detail;
}