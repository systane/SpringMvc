package br.com.dxc.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

@Configuration
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, SecurityConfiguration.class, WebConfig.class, JPAConfiguration.class, JPAProductionConfiguration.class};
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
        return new Filter[]{characterEncodingFilter, new OpenEntityManagerInViewFilter()}; //Deixa o entityManager aberto até na jsp para poder realizar um lazy initialization
    }

    @Override protected void customizeRegistration(ServletRegistration.Dynamic registration) { //Configura como o registro de um arquivo multipart será realizado
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }

//
//    @Override public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
//        servletContext.addListener(RequestContextListener.class); //Para poder setar o profile, primeiro é necessário escutar os contextos da aplicação
//        servletContext.setInitParameter("spring.profiles.active", "dev"); //define que o profile ativo para a aplicação será o dev
//    }
//
}
