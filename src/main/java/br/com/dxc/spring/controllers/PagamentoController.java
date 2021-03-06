package br.com.dxc.spring.controllers;

import br.com.dxc.spring.model.Carrinho;
import br.com.dxc.spring.model.DadosPagamento;
import br.com.dxc.spring.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.Callable;

@Controller
@RequestMapping("/pagamento")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

    @Autowired
    private Carrinho carrinho;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MailSender sender;

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)// Callable faz com q o retorno desse método será assincrono.
    public Callable<ModelAndView> finalizar(@AuthenticationPrincipal Usuario usuario, //injeta o usuário logado
                                            RedirectAttributes model){ //RedirectAttributes permite enviar um objeto para view durante o escopo de uma requisição

        // Criar uma classe anonima
        return() -> {
            String uri = "http://book-payment.herokuapp.com/payment";

            try{
                String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);  //faz requisições post/get/update
                System.out.println(response);

                enviarEmailCompraProduto(usuario);

                model.addFlashAttribute("sucesso", response);
                return new ModelAndView("redirect:/produtos");
            }catch (HttpClientErrorException e){
                e.printStackTrace();
                model.addFlashAttribute("falha", "Valor maior que o permitido");
                return new ModelAndView("redirect:/produtos");
            }

        };

    }

    private void enviarEmailCompraProduto(Usuario usuario) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject("Compra finalizada com sucesso");
        //email.setTo(usuario.getEmail());
        email.setTo("lf.silva@outlook.com");
        email.setText("Compra aprovada com sucesso no valor de: " + carrinho.getTotal());
        email.setFrom("fernandinho.sjrp@gmail.com");

        sender.send(email);
    }
}
