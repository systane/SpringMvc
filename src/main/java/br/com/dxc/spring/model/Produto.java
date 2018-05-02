package br.com.dxc.spring.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto {

    @Id @GeneratedValue(strategy =GenerationType.IDENTITY) //marca o campo Id e avisa o banco para ele se preocupar com a geração da PK
    private int id;

    private String titulo;
    private int paginas;

    @Lob //Indica que o objeto descrição deve ser persistido como um objeto grande (nesse caso como um campo grande de 255 caracteres). O Lob pode ser utilizado para armazenar também tipos de dados binários
    private String descricao;

    //@DateTimeFormat(pattern = "dd/MM/yyyy") --> formata um atributo com mascara especifica, permitindo o spring só aceitar esse tipo de mascara
    private Calendar dataLancamento;

    @ElementCollection //relaciona o preço como parte do produto
    private List<Preco> precos;

    private String sumarioPath;



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

    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
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

    public String getSumarioPath() {
        return sumarioPath;
    }

    public void setSumarioPath(String sumarioPath) {
        this.sumarioPath = sumarioPath;
    }

    @Override
    public String toString() {
        return "Produto{" + "titulo='" + titulo + '\'' + ", descricao='" + descricao + '\'' + ", paginas=" + paginas +'}';
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override public int hashCode() {
        return Objects.hash(id);
    }

    public BigDecimal precoPara(TipoPreco tipoPreco) {
        return precos.stream().filter(preco -> preco.getTipo().equals(tipoPreco)).findFirst().get().getValor();
    }
}
