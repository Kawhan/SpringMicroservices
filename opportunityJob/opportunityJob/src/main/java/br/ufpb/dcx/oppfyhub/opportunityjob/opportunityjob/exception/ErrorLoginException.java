package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code= HttpStatus.UNAUTHORIZED)
public class ErrorLoginException extends HTTPErrorException{
    public ErrorLoginException(String title, String details) {
        super(HttpStatus.UNAUTHORIZED, title, details);
    }

}
