package br.com.dxc.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class, JPAConfiguration.class}; //Seta a classe que vai mapear o contexto da aplicação para o spring
    }

    protected String[] getServletMappings() {
        return new String[]{"/"}; //O Spring vai mapear a partir da url /
    }
}
