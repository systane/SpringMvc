<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 5/3/2018
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
    <head>
        <title>${produto.titulo} - Casa do Código</title>

        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>

        <c:url value="/resources/css" var="cssPath"></c:url>
        <c:url value="/resources/js" var="jsPath"></c:url>

        <link rel="stylesheet" href="${cssPath}/bootstrap.css">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
        <script src="${jsPath}/bootstrap.js"></script>

        <link href="https://plus.googlecom/108540024862647200608" rel="publisher"/>
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/cssbase-min.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'/>
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/fonts.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/fontello-ie7.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/fontello-embedded.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/fontello.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/layout-colors.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/responsive-style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/guia-do-programador-style.css" rel="stylesheet" type="text/css"  media="all"  />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/produtos.css" rel="stylesheet" type="text/css"  media="all"  />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/book-collection.css" rel="stylesheet" type="text/css"  media="all"  />
        <link href="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/css/checkout-style.css" rel="stylesheet" type="text/css"  media="all"  />
    </head>
    <body>

        <header id="layout-header">
            <div class="clearfix container">
                <a href="${s:mvcUrl('HC#home').build()}" id="logo">
                    <img src="https://cdn.rawgit.com/alura-cursos/spring-mvc-i-criando-aplicacoes-web-master/master/src/main/webapp/resources/imagens/cdc-logo.svg" />
                </a>
                <div id="header-content">
                    <nav id="main-nav">
                        <ul class="clearfix">
                            <li>
                                <a href="${s:mvcUrl('CCC#itens').build()}" rel="nofollow">
                                    Carrinho ( ${carrinhoCompras.quantidade} )
                                </a>
                            </li>
                            <li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre Nós</a></li>
                            <li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <nav class="categories-nav">
            <ul class="container">
                <li class="category"><a href="http://www.casadocodigo.com.br">Home</a></li>
                <li class="category"><a href="/collections/livros-de-agile">
                    Agile </a></li>
                <li class="category"><a href="/collections/livros-de-front-end">
                    Front End </a></li>
                <li class="category"><a href="/collections/livros-de-games">
                    Games </a></li>
                <li class="category"><a href="/collections/livros-de-java">
                    Java </a></li>
                <li class="category"><a href="/collections/livros-de-mobile">
                    Mobile </a></li>
                <li class="category"><a
                        href="/collections/livros-desenvolvimento-web"> Web </a></li>
                <li class="category"><a href="/collections/outros"> Outros </a></li>
            </ul>
        </nav>
