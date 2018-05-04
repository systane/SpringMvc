<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 5/3/2018
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

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
                                Carrinho (${carrinho.quantidade})
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
