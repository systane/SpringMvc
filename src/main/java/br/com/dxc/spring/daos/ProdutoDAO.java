package br.com.dxc.spring.daos;

import br.com.dxc.spring.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext // Faz com que o spring injete o EntityManager
    private EntityManager manager;


    public void gravar(Produto produto){ manager.persist(produto);}


    public List<Produto> listar() {
        return manager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public Produto find(Integer id){ //query para pegar o produto e o preço de um produto
        /*return manager.createQuery("select distinct (p) from Produto p "
                + "join fetch p.precos preco where p.id = :id", Produto.class)
                .setParameter("id", id)
                .getSingleResult();*/
        return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id",
                Produto.class).setParameter("id", id).getSingleResult();
    }
}
