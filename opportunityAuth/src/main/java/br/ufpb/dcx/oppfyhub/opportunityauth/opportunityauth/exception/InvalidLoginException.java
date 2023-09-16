package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.exception;

public class InvalidLoginException extends ErrorLoginException{
    public InvalidLoginException() {
        super("Invalid Login", "The user has not been authenticated. The login request was successfully processed, but the information passed was not correct to successfully authenticate the user.");
    }

}
