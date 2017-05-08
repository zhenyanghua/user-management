package io.hua.common.web.exception;

public class MyPreconditionFailedException extends RuntimeException {

    public MyPreconditionFailedException() {
        super();
    }

    public MyPreconditionFailedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyPreconditionFailedException(final String message) {
        super(message);
    }

    public MyPreconditionFailedException(final Throwable cause) {
        super(cause);
    }
}
