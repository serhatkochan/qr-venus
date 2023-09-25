package xtech.qrvenus.core.utilities.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;

@RestControllerAdvice // AOP bütün hatalar aşağıdaki exceptionHandler'a taabi
public class ExceptionHandlers {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException businessException) { // business exception alırsa çalışacak
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(businessException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("VALIDATION_EXCEPTION");
        validationProblemDetails.setValidationErrors(new HashMap<String, String>());

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return validationProblemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleSQLGrammerException(SQLGrammarException sqlGrammarException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(sqlGrammarException.getSQLException().getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleIOException(IOException ioException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(ioException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleServletException(ServletException servletException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(servletException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleRuntimeException(RuntimeException runtimeException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(runtimeException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleInternalServerErrorException(Exception exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public ProblemDetails handleAccessDeniedException(AccessDeniedException accessDeniedException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(accessDeniedException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleAuthenticationException(AuthenticationException  authenticationException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(authenticationException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(AuthenticationServiceException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ProblemDetails handleAuthenticationServiceException(AuthenticationServiceException exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ProblemDetails handleBadCredentialsException(BadCredentialsException exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ProblemDetails handleExpiredJwtException(ExpiredJwtException expiredJwtException) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(expiredJwtException.getMessage());
        return problemDetails;
    }
}
