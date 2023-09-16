package br.ufpb.dcx.oppfyhub.opportunityjob.opportunityjob.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class NotFoundException extends HTTPErrorException{
    public NotFoundException(String title, String details) {
        super(HttpStatus.NOT_FOUND, title, details);
    }
}
