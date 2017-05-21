package io.hua.um.spring;

import com.google.common.collect.Lists;
import io.hua.common.spring.util.Profiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartupLoggingComponent implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String PERSISTENCE_TARGET_KEY = "persistenceTarget";
    private static final String ACTIVE_SPRING_PROFILE_KEY = "spring.profiles.active";
    private static final String PERSISTENCE_HOST_KEY = "jdbc.url";

    @Autowired
    private Environment env;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("=====================================================================================");

        try {
            logProfile(env);
            logPersistenceTarget(env);
            logPersistenceData(env);
        } catch (final Exception ex) {
            logger.warn("There was a problem logging data on startup", ex);
        }

        logger.info("=====================================================================================");
    }

    private void logProfile(final Environment env) {
        final String profile = getValueOfProperty(env, ACTIVE_SPRING_PROFILE_KEY, Profiles.DEVELOPMENT, Lists.newArrayList(Profiles.DEVELOPMENT, Profiles.PRODUCTION));
        logger.info("{} = {}", ACTIVE_SPRING_PROFILE_KEY, profile);
    }

    private void logPersistenceTarget(final Environment env) {
        final String persistenceTarget = getValueOfProperty(env, PERSISTENCE_TARGET_KEY, "h2", Lists.newArrayList("h2", "cargo"));
        logger.info("{} = {}", PERSISTENCE_TARGET_KEY, persistenceTarget);
    }

    private void logPersistenceData(final Environment env) {
        final String persistenceData = getValueOfProperty(env, PERSISTENCE_HOST_KEY, "not-found", null);
        logger.info("{} = {}", PERSISTENCE_HOST_KEY, persistenceData);
    }

    private final String getValueOfProperty(final Environment environment, final String propertyKey, final String propertyDefaultValue, final List<String> acceptablePropertyValues) {

        String propValue = environment.getProperty(propertyKey);
        if (propValue == null) {
            propValue = propertyDefaultValue;
            logger.info("The {} doesn't have an explicit value; default value is = {}", propertyKey, propertyDefaultValue);
        }

        if (acceptablePropertyValues != null) {
            if (!acceptablePropertyValues.contains(propValue)) {
                logger.warn("The property = {} has an invalid value = {}", propertyKey, propValue);
            }
        }

        if (propValue == null) {
            logger.warn("The property = {} is null", propertyKey);
        }

        return propValue;
    }

}
