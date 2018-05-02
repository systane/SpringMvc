package br.com.dxc.spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.dxc.spring") //seta o pacote no qual o spring vai procurar por objetos de configuração, controllers, etc.
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        //resolver.setExposeContextBeansAsAttributes(true); Seta os beans para ficarem disponiveis como atributos na JSP
        resolver.setExposedContextBeanNames("carrinho");
        return resolver;
    }

    @Bean //avisa para o spring que o método deve criar um objeto q será gerenciado pelo spring
    public MessageSource messageSource(){ //configura o spring para usar o message.properties
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1);

        return messageSource;
    }

    @Bean //Método para formatar todas as datas que serão recebidas pelo Spring no padrão dd/MM/yyyy. O Back só aceitará esse tipo de formato
    public FormattingConversionService mvcConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
        registrar.registerFormatters(conversionService);

        return conversionService;
    }


    @Bean
    public MultipartResolver multipartResolver(){ //Método para resolver os arquivos de multiplos formatos(multipart como arquivos de  anexo que contém o arquivo pdf e as informações do arquivo)
        return new StandardServletMultipartResolver();
    }

}
