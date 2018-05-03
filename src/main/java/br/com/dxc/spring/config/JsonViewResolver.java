package br.com.dxc.spring.config;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

public class JsonViewResolver implements org.springframework.web.servlet.ViewResolver {

    @Override public View resolveViewName(String viewName, Locale locale) throws Exception { //Método para configurar o retorno de uma view para um cliente como Json
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);

        return jsonView;

    }
}
