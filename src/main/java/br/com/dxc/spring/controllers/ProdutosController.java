package br.com.dxc.spring.controllers;

import br.com.dxc.spring.daos.ProdutoDAO;
import br.com.dxc.spring.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

    @Autowired //injeta um objeto do classe ProdutoDao que tem @Repository
    private ProdutoDAO produtoDao;

    @RequestMapping("/produtos/form")
    public String form(){
        return "produtos/form";
    }


    @RequestMapping("/produtos")
    public String grava(Produto produto){
        System.out.println(produto);
        produtoDao.gravar(produto);
        return "produtos/ok";
    }
}
