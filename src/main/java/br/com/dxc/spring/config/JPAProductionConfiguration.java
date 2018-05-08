package br.com.dxc.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@Profile("prod")
public class JPAProductionConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public Properties additionalProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        return props;
    }

    @Bean
    public DataSource dataSource() throws URISyntaxException { //Configura a conexão com o dataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        URI dbUrl = new URI(environment.getProperty("DATABASE_URL")); //variável de ambiente do heruko usada para obter as configurações do banco (usuario:senha@host:port/path)

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername(dbUrl.getUserInfo().split(":")[0]);
        dataSource.setPassword(dbUrl.getUserInfo().split(":")[1]);
        dataSource.setUrl("jdbc:postgresql://"+ dbUrl.getHost() +":"+ dbUrl.getPort() + dbUrl.getPath());


        return dataSource;
    }

}
