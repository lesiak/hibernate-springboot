package com.example.h2customizationspringboot.config;

import org.h2.server.web.CustomH2WebServlet;
import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({H2ConsoleProperties.class, DataSourceProperties.class})
@Configuration
public class H2Config {

    private final H2ConsoleProperties h2ConsoleProperties;

    private final DataSourceProperties dataSourceProperties;

    public H2Config(H2ConsoleProperties h2ConsoleProperties, DataSourceProperties dataSourceProperties) {
        this.h2ConsoleProperties = h2ConsoleProperties;
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public ServletRegistrationBean<WebServlet> h2Console() {
        String path = this.h2ConsoleProperties.getPath();
        String urlMapping = path + (path.endsWith("/") ? "*" : "/*");
        ServletRegistrationBean<WebServlet> registration = new ServletRegistrationBean<>(
                new CustomH2WebServlet(this.dataSourceProperties.getUrl()), urlMapping);
        H2ConsoleProperties.Settings settings = this.h2ConsoleProperties.getSettings();
        if (settings.isTrace()) {
            registration.addInitParameter("trace", "");
        }
        if (settings.isWebAllowOthers()) {
            registration.addInitParameter("webAllowOthers", "");
        }
        return registration;
    }


}
