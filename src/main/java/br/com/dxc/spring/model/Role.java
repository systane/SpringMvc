package br.com.dxc.spring.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements GrantedAuthority{

    private static final long serivalVersionUID = 1L;

    @Id
    private String nome;

    public Role(){

    }

    public Role(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override public String getAuthority() {
        return this.nome;
    }
}
