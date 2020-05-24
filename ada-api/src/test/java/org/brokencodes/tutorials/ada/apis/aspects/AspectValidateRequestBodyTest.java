package org.brokencodes.tutorials.ada.apis.aspects;

import org.aspectj.lang.JoinPoint;
import org.brokencodes.tutorials.ada.apis.annotations.ValidateRequestBody;
import org.brokencodes.tutorials.ada.apis.endpoints.base.IRequestBodyValidator;
import org.brokencodes.tutorials.ada.apis.endpoints.base.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AspectValidateRequestBodyTest {

    @InjectMocks
    private AspectValidateRequestBody sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void validateRequestBody() {
        JoinPoint mockedJoinPoint = mock(JoinPoint.class);
        ValidateRequestBody mockedVerifiableRequestBody = mock(ValidateRequestBody.class);

        when(mockedJoinPoint.getArgs()).thenReturn(new Object[]{new ValidateRequestBodyArgument()});
        when(mockedVerifiableRequestBody.enabled()).thenReturn(true);

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> sut.validateRequestBody(mockedJoinPoint, mockedVerifiableRequestBody));
        assertThat(exception.getMessage()).isEqualTo("400 BAD_REQUEST \"Validation Error\"");

        when(mockedVerifiableRequestBody.enabled()).thenReturn(false);
        sut.validateRequestBody(mockedJoinPoint, mockedVerifiableRequestBody);
    }

    private static class ValidateRequestBodyArgument implements IRequestBodyValidator {

        @Override
        public Validation validate() {
            return Validation.builder()
                    .message("Validation Error")
                    .failed(true)
                    .build();
        }

    }

}