package io.hua.common.web.util;

import io.hua.common.web.exception.MyConflictException;
import io.hua.common.web.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

public final class RestUtil {

    private RestUtil() {
        throw new AssertionError();
    }

    /**
     * This is to be used when a Create REST request is sent to another service
     *  - if the response does not have the expected 201 status code, then an
     *  exception is thrown.
     *
     * @param createResponse the response returned on create
     * @param message the message to show if failed to create
     */
    public static void propagateStatusCodeOnCreate(final ResponseEntity<?> createResponse, final String message) {
        if (createResponse.getStatusCode().value() == 409) {
            throw new MyConflictException(message);
        }
        if (createResponse.getStatusCode().value() != 201) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * This is to be used when an exception is
     * @param ex 
     * @param message
     */
    public static void propagateStatusCodeOnException(final HttpStatusCodeException ex, final String message) {
        if (ex.getStatusCode().value() == 409) {
            throw new ValidationException(ex.getStatusText());
        }

        throw new IllegalStateException(message);
    }
}
