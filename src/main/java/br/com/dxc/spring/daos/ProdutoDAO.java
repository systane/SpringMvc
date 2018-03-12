package br.com.dxc.spring.daos;

import br.com.dxc.spring.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext // Faz com que o spring injete o EntityManager
    private EntityManager manager;


    public void gravar(Produto produto){ manager.persist(produto);}


}
