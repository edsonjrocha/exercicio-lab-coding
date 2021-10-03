package br.com.impacta.ejrocha.exerciciolabcoding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UpdateErrorException extends Exception {
    public UpdateErrorException(String msg) {
        super(msg);
    }
}
