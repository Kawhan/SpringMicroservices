package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.exception;

public class NotAuthorizedException extends ErrorLoginException{
    public NotAuthorizedException() {
        super("User does not have permission", "The requested operation cannot be performed by this user");
    }
}
