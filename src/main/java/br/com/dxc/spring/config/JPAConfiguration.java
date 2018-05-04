package br.com.dxc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement //habilita o spring a trabalhar com transações
public class JPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){//recebe o dataSource através da injeção de independencias do Spring

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("br.com.dxc.spring.model"); //configura onde o spring procurará as entidades do banco
        factoryBean.setDataSource(dataSource);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter); //informa a especificação do JPA que a aplicação vai utilizar
        Properties properties = aditionalProperties(factoryBean);

        return factoryBean;
    }

    public Properties aditionalProperties(LocalContainerEntityManagerFactoryBean factoryBean) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");//Configura as propriedades do hibernate (dialeto que o hibernate comunicará com o BD)
        properties.setProperty("hibernate.show_sql", "true"); //Permite ver o sql gerado pelo hibernate
        properties.setProperty("hibernate.hbm2ddl.auto", "update"); //Toda vez que o modelo for atualizado, o hibernate gerará/atualizará o banco
        factoryBean.setJpaProperties(properties);
        return properties;
    }

    @Bean
    @Profile("dev")
    public DataSource dataSource() { //Configura a conexão com o dataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        
        return dataSource;        
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);//Associa o JPATrascationManager com o EntityManager
    }
}
