package io.hua.um;

import io.hua.um.spring.UmContextConfig;
import io.hua.um.spring.UmPersistenceJpaConfig;
import io.hua.um.spring.UmServiceConfig;
import io.hua.um.spring.UmWebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = {UmPersistenceJpaConfig.class, UmServiceConfig.class, UmContextConfig.class, UmWebConfig.class}
)
@WebAppConfiguration
public class WebSpringIntegrationTest {

    @Test
    public final void whenContextIsBootstrapped_thenOk() {

    }
}
