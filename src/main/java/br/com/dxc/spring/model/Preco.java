package br.com.dxc.spring.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable //O Preço vai ser parte do produto
public class Preco {

    private BigDecimal valor;
    private TipoPreco tipo;



    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }
}
