package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotFoundUserException extends NotFoundException{
    public NotFoundUserException() {
        super("User not found", "User not registered in the system");
    }
}
