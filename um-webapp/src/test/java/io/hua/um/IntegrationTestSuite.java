package io.hua.um;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    PersistenceSpringIntegrationTest.class,
    ServiceSpringIntegrationTest.class,
    WebSpringIntegrationTest.class
})
public class IntegrationTestSuite {

}
