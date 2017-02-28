package com.altoros.integration.stagemonitor.boot;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.stagemonitor.web.WebPlugin;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(ServletContextInitializer.class)
@AutoConfigureAfter(EmbeddedServletContainerAutoConfiguration.class)
public class WebPluginAutoConfigurationSpring {

    @Bean
    public EmbeddedServletContainerCustomizer pluginInitializer() {
        System.out.println("Monitoring: starting Web Plugin initialization ...");
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ServletContextInitializer servletContextInitializer = new ServletContextInitializer() {
                    @Override
                    public void onStartup(ServletContext servletContext) throws ServletException {
                        new WebPlugin().onStartup(null, servletContext);
                    }
                };
                container.addInitializers(servletContextInitializer);
            }
        };
    }
}
