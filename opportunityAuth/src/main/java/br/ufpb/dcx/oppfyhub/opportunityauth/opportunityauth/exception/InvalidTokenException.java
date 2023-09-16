package br.ufpb.dcx.oppfyhub.opportunityauth.opportunityauth.exception;

public class InvalidTokenException extends ErrorLoginException{
    public InvalidTokenException() {
        super("Invalid Token", "Missing or badly formatted token");
    }
}
