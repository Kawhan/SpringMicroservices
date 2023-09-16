package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception;

public class InvalidTokenException extends ErrorLoginException{
    public InvalidTokenException() {
        super("Invalid Token", "Missing or badly formatted token");
    }
}
