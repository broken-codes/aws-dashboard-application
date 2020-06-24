package org.brokencodes.tutorials.ada.apis.endpoints.base;

import lombok.*;

import javax.annotation.PostConstruct;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Validation {

    private String message;

    @Getter(AccessLevel.NONE)
    private boolean failed;

    @PostConstruct
    public void postConstruct() {
        failed = true;
    }

    public boolean hasFailed() {
        return failed;
    }

}
