package br.com.dxc.spring.model;

import java.util.Objects;

public class CarrinhoItem {
    private Produto produto;
    private TipoPreco tipoPreco;

    public CarrinhoItem(Produto produto, TipoPreco tipoPreco) {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CarrinhoItem that = (CarrinhoItem) o;
        return Objects.equals(produto, that.produto) && tipoPreco == that.tipoPreco;
    }

    @Override public int hashCode() {
        return Objects.hash(produto, tipoPreco);
    }
}
