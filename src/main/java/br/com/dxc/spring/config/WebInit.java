package br.com.dxc.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

@Configuration
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, SecurityConfiguration.class, WebConfig.class, JPAConfiguration.class};
    } // Spring vai subir as configurações assim que o sistema iniciar, e não no primeiro acesso a aplicação.

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{}; //Seta a classe que vai mapear o contexto da aplicação para o spring a partir da primeira inicialização
    }

    protected String[] getServletMappings() {
        return new String[]{"/"}; //O Spring vai mapear a partir da url /
    }

    @Override protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8"); // todo requisição do Spring será utilizado o enconding UTF-8
        return new Filter[]{characterEncodingFilter};
    }

    @Override protected void customizeRegistration(ServletRegistration.Dynamic registration) { //Configura como o registro de um arquivo multipart será realizado
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }
}
