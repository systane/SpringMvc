package br.com.dxc.spring.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Carrinho implements Serializable { //Sempre q um bean do Spring tiver o scope de SESSION, é interessante implementar Serializable
                                                // pois toda vez o servidor "salva" uma sessão, ele salva o bean em arquivo e quando o usuário voltar
                                                // a utilizar a sessão o servidor retorna o arquivo
                                                //proxyMode = TargetClass --> Significa que o próprio Spring vai fz um proxy para resolver as dependencias nas classes alvo do Carrinho

    private static final long serialVersionUID = 1L;

    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();


    public void add(CarrinhoItem item){
        itens.put(item, getQuantidade(item) + 1);
    }

    public Integer getQuantidade(CarrinhoItem item) {
        if(!itens.containsKey(item)){
            itens.put(item, 0);
        }
        return itens.get(item);
    }

    public Collection<CarrinhoItem> getItens() {
        return itens.keySet(); // retorna uma lista ou uma collection de carrinho item
    }

    public int getQuantidade(){
        return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }


    public BigDecimal getTotal(CarrinhoItem item){
        return item.getTotal(getQuantidade(item));
    }


    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;

        for(CarrinhoItem item: itens.keySet()){
            total = total.add(getTotal(item));
        }

        return total;
    }

    public void remover(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = new Produto();
        produto.setId(produtoId);
        itens.remove(new CarrinhoItem(produto, tipoPreco));
    }
}
