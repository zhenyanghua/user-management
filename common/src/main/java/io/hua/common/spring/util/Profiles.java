package io.hua.common.spring.util;

public final class Profiles {

    public static final String DEVELOPMENT = "development";
    public static final String PRODUCTION = "production";
    public static final String DEPLOYED = "deployed";

    private Profiles() {
        throw new AssertionError();
    }
}
