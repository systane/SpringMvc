package br.com.dxc.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produto {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY) //marca o campo Id e avisa o banco para ele se preocupar com a geração da PK
    private int id;
    private String titulo;
    private String descricao;
    private int paginas;
    @ElementCollection //relaciona o preço como parte do produto
    private List<Preco> precos;



    public Produto() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Preco> getPrecos() {
        return precos;
    }

    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }

    @Override
    public String toString() {
        return "Produto{" + "titulo='" + titulo + '\'' + ", descricao='" + descricao + '\'' + ", paginas=" + paginas + '}';
    }
}
