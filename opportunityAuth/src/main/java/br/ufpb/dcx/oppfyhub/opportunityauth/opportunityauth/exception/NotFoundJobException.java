package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.exception;

public class NotFoundJobException extends NotFoundException{
    public NotFoundJobException(){
        super("Job not found", "Job not registered in the system");
    }
}
