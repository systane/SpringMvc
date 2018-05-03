package br.com.dxc.spring.controllers;

import br.com.dxc.spring.daos.ProdutoDAO;
import br.com.dxc.spring.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/")
    @Cacheable(value = "produtosHome")
    public ModelAndView home(){
        List<Produto> produtos = produtoDAO.listar();

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }

}
