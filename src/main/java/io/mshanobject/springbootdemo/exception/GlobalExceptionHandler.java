package io.mshanobject.springbootdemo.exception;

import io.mshanobject.springbootdemo.model.ErrorMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ArithmeticException.class)
    public ErrorMsg handleBaseException(ArithmeticException e) {
        ErrorMsg errorMsg = new ErrorMsg();
        errorMsg.setErrorCode("001");
        errorMsg.setMessage("0으로 나누셨군요.");
        errorMsg.setTechnicalMessage(e.getMessage());
        return errorMsg;
    }

    @ExceptionHandler(value = BadSqlGrammarException.class)
    public ErrorMsg handleBaseException(BadSqlGrammarException e) {
        ErrorMsg errorMsg = new ErrorMsg();
        errorMsg.setErrorCode("002");
        errorMsg.setMessage("데이터베이스에 문제가 있어요. 문제를 확인해보세요.");
        errorMsg.setTechnicalMessage(e.getMessage());
        return errorMsg;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    protected String handle(HttpClientErrorException.BadRequest e) {
        log.error("HttpClientErrorException.BadRequest", e);

        return "잘못된 요청입니다. 정상적인 방법으로 접근해주시기 바랍니다.";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
