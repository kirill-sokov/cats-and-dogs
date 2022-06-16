package ks.catsndogs.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalRestExceptionHandler implements ProblemHandling, SecurityAdviceTrait {

    @ExceptionHandler({
            EntityNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> handleNotFoundError(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
            JpaSystemException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Problem> handleJPAError(JpaSystemException e) {
        return ResponseEntity.internalServerError().body(Problem.builder()
                .withStatus(Status.INTERNAL_SERVER_ERROR)
                .withTitle("Failed to execute request")
                .withDetail(e.getMessage())
                .build()
        );
    }
}
