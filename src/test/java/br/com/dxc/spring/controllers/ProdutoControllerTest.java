package br.com.dxc.spring.controllers;

import br.com.dxc.spring.config.DataSourceConfigurationTest;
import br.com.dxc.spring.config.JPAConfiguration;
import br.com.dxc.spring.config.WebConfig;
import br.com.dxc.spring.config.WebInit;
import br.com.dxc.spring.daos.ProdutoDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class, WebConfig.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProdutoControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void deveRetornarParaHomeComOsLivros() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")) //perform faz uma requisição em um engereço
                .andExpect(MockMvcResultMatchers.model().attributeExists("produtos"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/home.jsp"));
    }

    @Test
    public void somenteAdminDeveAcessarProdutosForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/produtos/form")
                .with(SecurityMockMvcRequestPostProcessors
                        .user("user@dxc.com.br")
                        .password("123456")
                        .roles("USUARIO")))
                    .andExpect(MockMvcResultMatchers.status().is(403));
    }
}
