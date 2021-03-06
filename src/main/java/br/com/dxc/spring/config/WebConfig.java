package br.com.dxc.spring.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.dxc.spring") //seta o pacote no qual o spring vai procurar por objetos de configuração, controllers, etc.
@EnableCaching // Habilita o cache do spring
public class WebConfig extends WebMvcConfigurerAdapter { //WebMvcConfigurerAdapter herda métodos para poder ter mais opções de configurações do spring

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

    @Bean
    public RestTemplate restTemplate(){// Serve para retornar um RestTemplate para o Spring
        return new RestTemplate();
    }

    @Bean
    public CacheManager cacheManager(){ //instancia um novo administrador da cache para o spring

        //Configura a cache
        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().
                maximumSize(100). //guarda 100 elementos de produtos
                expireAfterAccess(60, TimeUnit.MINUTES); //Cache expira a cada 5 minutos

        GuavaCacheManager cacheManager = new GuavaCacheManager(); // Guava --> Gerenciador de cache feito pela google
        cacheManager.setCacheBuilder(builder);

        return cacheManager;
    }

    @Bean
    public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager manager){ // Método q vai resolver qual conteudo o cliente quer (html ou json)

        List<ViewResolver> viewResolvers = new ArrayList<>(); //Cria uma lista de resolver (resolver da JSP e do JSON)
        viewResolvers.add(resolver());
        viewResolvers.add(new JsonViewResolver());


        //Resolve qual view irá abrir (json ou html)
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setViewResolvers(viewResolvers);
        resolver.setContentNegotiationManager(manager);//Seta o manager. Ele que decide qual viewResolver será retornada para o cliente

        return resolver;
    }

    @Override public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { //Avisa o spring qual é o servlet que vai capturar requisições de recursos (html, js, css). Se é o servlet do spring ou do servlet Container (Tomcat)
        configurer.enable(); // Com o configurar habilitado, os arquivos de recursos vão para o servlet do TomCat
    }

    //Adiciona um interceptor para lidar com a mudança de localidade do front
    @Override public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

    //Configura o spring para resolver o locale através do cookie
    @Bean
    public LocaleResolver localeResolver(){
        return new CookieLocaleResolver();
    }

    @Bean
    public MailSender mailSender(){ //configura um mailSender para ser utilizado pelo spring
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setUsername("fernandinho.sjrp@gmail.com");
        mailSender.setPassword("lspqlsseflhxtrax");
        mailSender.setPort(587);

        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", true); //Habilita o sistema para usar autenticação
        mailProperties.put("mail.smtp.starttls.enable", true); //Habilita o sistema para usar tls (obrigatório na comunicação com servidores seguros)

        mailSender.setJavaMailProperties(mailProperties);

        return mailSender;

    }
}
