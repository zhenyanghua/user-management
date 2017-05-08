package io.hua.common.web.exception;

public class MyResourceNotFoundException extends RuntimeException {

    public MyResourceNotFoundException() {
    }

    public MyResourceNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyResourceNotFoundException(final String message) {
        super(message);
    }

    public MyResourceNotFoundException(final Throwable cause) {
        super(cause);
    }
}
