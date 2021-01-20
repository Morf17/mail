package config;

public final class TestConfig {

    public static final int IMPLICITLY_WAIT_IN_SECONDS;
    public static final int IMPLICITLY_WAIT_SHORT_TIMEOUT_IN_MILLISECONDS;
    public static final String ENVIRONMENT_URL;
    public static final String EMAIL_PREFIX;
    public static final String EMAIL_PASSWORD;

    static {
        IMPLICITLY_WAIT_IN_SECONDS = Integer.parseInt(PropertiesConfig.get("IMPLICITLY_WAIT_IN_SECONDS"));
        IMPLICITLY_WAIT_SHORT_TIMEOUT_IN_MILLISECONDS = Integer.parseInt(PropertiesConfig.get("IMPLICITLY_WAIT_SHORT_TIMEOUT_IN_MILLISECONDS"));
        ENVIRONMENT_URL = PropertiesConfig.get("ENVIRONMENT_URL");
        EMAIL_PREFIX = PropertiesConfig.get("EMAIL_PREFIX");
        EMAIL_PASSWORD = PropertiesConfig.get("EMAIL_PASSWORD");
    }
}
