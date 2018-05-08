package br.com.dxc.spring.config;

import br.com.dxc.spring.daos.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@EnableWebSecurity
@EnableWebMvcSecurity //Anotação para habilitar para o spring q essa classe será de configuração de segurança
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UsuarioDAO usuarioDao; //Classe com as configurações de segurança da aplicação

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/produtos/form").hasRole("ADMIN")
                .antMatchers("carrinho/**").permitAll()
                .antMatchers("/pagamento/**").permitAll()
                .antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/produtos").hasRole("ADMIN")
                .antMatchers("/produtos/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers(HttpMethod.GET,  "/produtos/").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/url-magica-aaaaaaaaaaaa").permitAll()
                .anyRequest().authenticated().and().formLogin()//verifica se todo request está autenticado
                                                                // Senão tiver, redirecionar para o formLogin
                .loginPage("/login").permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); //Adiciona uma url para logout


    }

    @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioDao).passwordEncoder(new BCryptPasswordEncoder());
    }
}
