package io.hua.common.web;

import io.hua.common.web.exception.MyBadRequestException;
import io.hua.common.web.exception.MyConflictException;
import io.hua.common.web.exception.MyResourceNotFoundException;

public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    public static <T> T checkNotNull(final T reference) {
        return checkNotNull(reference, null);
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     * @param reference an object reference
     * @param message the message of the exception if the check fails
     * @return the non-null reference that was validated
     * @throws MyResourceNotFoundException if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference, final String message) {
        if (reference == null) {
            throw new MyResourceNotFoundException(message);
        }
        return reference;
    }

    public static <T> T checkRequestElementNotNull(final T reference) {
        return checkRequestElementNotNull(reference, null);
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     * @param reference an object reference
     * @param message the message of the exception if the check fails
     * @return the non-null reference that was validated
     * @throws MyBadRequestException if {@code reference} is null
     */
    public static <T> T checkRequestElementNotNull(final T reference, final String  message) {
        if (reference == null) {
            throw new MyBadRequestException(message);
        }
        return reference;
    }

    public static void checkRequestState(final boolean expression) {
        checkRequestElementNotNull(expression, null);
    }

    /**
     * Ensures the truth of an expression
     * @param expression a boolean expression
     * @param message the message of the exception if the check fails
     * @throws MyConflictException if {@code expression} is false
     */
    public static void checkRequestState(final boolean expression, final String message) {
        if (!expression) {
            throw new MyConflictException(message);
        }
    }

    public static void checkIfBadRequest(final boolean expression) {
        checkIfBadRequest(expression, null);
    }

    /**
     * Ensures the truth of an expression related to the validity of the request
     * @param expression a boolean expression
     * @param message the message of the exception if the check fails
     * @throws MyBadRequestException if ${@code expression} is false
     */
    public static void checkIfBadRequest(final boolean expression, final String message) {
        if (!expression) {
            throw new MyBadRequestException(message);
        }
    }
}
