package br.com.dxc.spring.validation;

import br.com.dxc.spring.model.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProdutoValidation implements Validator{

    public boolean supports(Class<?> clazz) { //método utilizado para saber a classe Produto suporta a classe validator do spring
        return Produto.class.isAssignableFrom(clazz);
    }

    public void validate(Object object, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        Produto produto = (Produto) object;

        if(produto.getPaginas() <= 0){
            errors.rejectValue("paginas", "field.required");
        }
    }
}
