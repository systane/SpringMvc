package br.com.dxc.spring.controllers;

import br.com.dxc.spring.daos.ProdutoDAO;
import br.com.dxc.spring.infra.FileSaver;
import br.com.dxc.spring.model.Produto;
import br.com.dxc.spring.model.TipoPreco;
import br.com.dxc.spring.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired //injeta um objeto do classe ProdutoDao que tem @Repository
    private ProdutoDAO produtoDao;

    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    public void initBinder(WebDataBinder binder){ //Método para ligar o validator do spring com a classe ProdutoValidation
        binder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form(Produto produto){
        ModelAndView modelAndView = new ModelAndView("produtos/form"); //adiciona um atributo para ser enviado para a jsp passado como parametro
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.POST)
    @CacheEvict(value = "produtosHome", allEntries = true) //Limpa todos as entradas (produtos) que estão na cache produtosHome
    public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){

        System.out.println(sumario.getOriginalFilename());



        if(result.hasErrors()){ //Caso ocorra um erro, retornar para o formulário
            System.out.println(result.getAllErrors());
            return form(produto);
        }

        String path = fileSaver.write("arquivos-sumario", sumario);
        produto.setSumarioPath(path);
        produtoDao.gravar(produto);
        //ModelAndView modelAndView = new ModelAndView("redirect:produtos");faz um redirecionamento da página após o post
        redirectAttributes.addFlashAttribute("sucesso", "Produto Cadastrado com sucesso!"); //mantém os atributos do request com um tempo de vida flash(entre uma requisição e outra)

        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(){
        List<Produto> produtos = produtoDao.listar();
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

    @RequestMapping("/detalhe/{id}")
    public ModelAndView detalhe(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("produtos/detalhe");

        Produto produto = produtoDao.find(id);

        modelAndView.addObject("produto", produto);

        return modelAndView;
    }

//    @RequestMapping("/{id}")
//    @ResponseBody
//    public Produto detalheJson(@PathVariable("id") Integer id){
//        return produtoDao.find(id);
//    }
}
