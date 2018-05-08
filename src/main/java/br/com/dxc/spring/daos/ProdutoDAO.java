package br.com.dxc.spring.daos;

import br.com.dxc.spring.model.Produto;
import br.com.dxc.spring.model.TipoPreco;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext // Faz com que o spring injete o EntityManager
    private EntityManager manager;


    public void gravar(Produto produto){ manager.persist(produto);}


    public List<Produto> listar() { // join fetch faz o carregamento  dos precosna hr de executar a query de busca pelos produtos
        return manager.createQuery("select distinct (p) from Produto p", Produto.class).getResultList();
    }

    public Produto find(Integer id){ //query para pegar o produto e o preço de um produto
        /*return manager.createQuery("select distinct (p) from Produto p "
                + "join fetch p.precos preco where p.id = :id", Produto.class)
                .setParameter("id", id)
                .getSingleResult();*/
        return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id",
                Produto.class).setParameter("id", id).getSingleResult();
    }

    public BigDecimal somaPrecosPorTipo(TipoPreco tipoPreco){
        TypedQuery<BigDecimal> query = manager.createQuery("select sum(preco.valor) from Produto p join p.precos preco"
                + " where preco.tipo = :tipoPreco", BigDecimal.class);

        query.setParameter("tipoPreco", tipoPreco);

        return query.getSingleResult();
    }

}
