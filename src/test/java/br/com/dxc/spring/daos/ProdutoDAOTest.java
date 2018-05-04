package br.com.dxc.spring.daos;

import br.com.dxc.spring.builders.ProdutoBuilder;
import br.com.dxc.spring.config.DataSourceConfigurationTest;
import br.com.dxc.spring.config.JPAConfiguration;
import br.com.dxc.spring.model.Produto;
import br.com.dxc.spring.model.TipoPreco;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //Avisa o JUnit para rodar os teste com o SprintJunit
@ContextConfiguration(classes = {JPAConfiguration.class, ProdutoDAO.class, DataSourceConfigurationTest.class}) //Mapeia os arquivos de configuração
@ActiveProfiles("test") //Selecione o perfil te teste (Perfil com configurações de banco para rodar testes)
public class ProdutoDAOTest {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Test
    @Transactional
    public void deveSomarTodosPrecosPorTipoLivro(){

        List<Produto> livrosImpressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN)
                                            .more(3).buildAll();

        List<Produto> livrosEbook = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN)
                                            .more(3).buildAll();

        livrosImpressos.stream().forEach(produtoDAO::gravar);
        livrosEbook.stream().forEach(produtoDAO::gravar);

        BigDecimal valor = produtoDAO.somaPrecosPorTipo(TipoPreco.EBOOK);
        Assert.assertEquals(new BigDecimal(40).setScale(2), valor);
    }
}
