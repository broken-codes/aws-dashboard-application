package org.brokencodes.tutorials.ada.apis.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.brokencodes.tutorials.ada.apis.annotations.ValidateRequestBody;
import org.brokencodes.tutorials.ada.apis.endpoints.base.IRequestBodyValidator;
import org.brokencodes.tutorials.ada.apis.endpoints.base.Validation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Objects;

@Component
@Aspect
public class AspectValidateRequestBody {

    @Before("@annotation(validateRequestBody)")
    public void validateRequestBody(JoinPoint joinPoint, ValidateRequestBody validateRequestBody) {
        if (!validateRequestBody.enabled()) {
            return;
        }
        Arrays.stream(joinPoint.getArgs())
                .filter(obj -> obj instanceof IRequestBodyValidator)
                .map(validator -> ((IRequestBodyValidator) validator))
                .map(IRequestBodyValidator::validate)
                .filter(Objects::nonNull)
                .filter(Validation::hasFailed)
                .findFirst()
                .ifPresent(validation -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validation.getMessage());
                });
    }

}
