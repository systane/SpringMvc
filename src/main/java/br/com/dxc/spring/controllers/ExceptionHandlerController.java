package br.com.dxc.spring.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class) // método para tratar toda exception q acontecer no sistema
    public ModelAndView tratarDExceptionGenerica(Exception exception){
        System.out.println("Erro genérico acontecendo");
        exception.printStackTrace();

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
