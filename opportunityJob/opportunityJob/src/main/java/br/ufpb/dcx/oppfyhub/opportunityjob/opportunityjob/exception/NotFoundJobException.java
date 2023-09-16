package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception;

public class NotFoundJobException extends NotFoundException{
    public NotFoundJobException(){
        super("Job not found", "Job not registered in the system");
    }
}
