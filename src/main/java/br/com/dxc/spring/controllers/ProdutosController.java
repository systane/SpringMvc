package br.com.dxc.spring.controllers;

import br.com.dxc.spring.daos.ProdutoDAO;
import br.com.dxc.spring.model.Produto;
import br.com.dxc.spring.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("produtos")
public class ProdutosController {

    @Autowired //injeta um objeto do classe ProdutoDao que tem @Repository
    private ProdutoDAO produtoDao;

    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView modelAndView = new ModelAndView("produtos/form"); //adiciona um atributo para ser enviado para a jsp passado como parametro
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView grava(Produto produto, RedirectAttributes redirectAttributes){
        System.out.println(produto);
        produtoDao.gravar(produto);
        //ModelAndView modelAndView = new ModelAndView("redirect:produtos");faz um redirecionamento da página após o post
        redirectAttributes.addFlashAttribute("sucesso", "Produto Cadastrado com sucesso!"); //mantém os atributos do request com um tempo de vida flash(entre uma requisição e outra)

        return new ModelAndView("redirect:produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(){
        List<Produto> produtos = produtoDao.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }
}
