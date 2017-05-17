package io.hua.um.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "io.hua.um.service" })
public class UmServiceConfig {
    public UmServiceConfig() {
        super();
    }
}
