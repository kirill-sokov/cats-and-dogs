package ks.catsndogs.configurations;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

@ControllerAdvice
public class GlobalRestExceptionHandler implements ProblemHandling, SecurityAdviceTrait {

}
