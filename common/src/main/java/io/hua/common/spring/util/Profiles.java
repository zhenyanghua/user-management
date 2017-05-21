package io.hua.common.spring.util;

public final class Profiles {

    public static final String DEVELOPMENT = "development";
    public static final String PRODUCTION = "production";

    private Profiles() {
        throw new AssertionError();
    }
}
