package io.hua.um;

import io.hua.um.spring.UmPersistenceJpaConfig;
import io.hua.um.spring.UmServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = {UmPersistenceJpaConfig.class, UmServiceConfig.class},
    loader = AnnotationConfigContextLoader.class
)
public class ServiceSpringIntegrationTest {

    @Test
    public final void whenContextIsBootstrapped_thenOk() {

    }
}
