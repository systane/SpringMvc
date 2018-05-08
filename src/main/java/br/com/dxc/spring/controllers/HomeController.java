package br.com.dxc.spring.controllers;

import br.com.dxc.spring.daos.ProdutoDAO;
import br.com.dxc.spring.daos.UsuarioDAO;
import br.com.dxc.spring.model.Produto;
import br.com.dxc.spring.model.Role;
import br.com.dxc.spring.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private UsuarioDAO usuarioDao;

    @RequestMapping("/")
    @Cacheable(value = "produtosHome")
    public ModelAndView home(){
        List<Produto> produtos = produtoDAO.listar();

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos", produtos);

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/url-magica-aaaaaaaaaaaa")
    @Transactional
    public String urlMagica(){
        Usuario usuario = new Usuario();
        usuario.setNome("Admin");
        usuario.setEmail("admin@dxc.com.br");
        usuario.setSenha("$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu"); //123456
        usuario.setRoles(Arrays.asList(new Role("ADMIN")));

        usuarioDao.gravar(usuario);

        return "Url Magica executada";
    }

}
