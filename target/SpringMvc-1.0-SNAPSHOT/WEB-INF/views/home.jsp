<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 3/12/2018
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <title>Livros de Java, SOA, Android, iPhone, Ruby on Rails e
                     muito mais - Casa do Código</title>
    </head>
    <body>
        <section id="index-section" class="container middle">
            <h1 class="cdc-call">Últimos dias com os preços promocionais. Aproveite!</h1>
            <ul class="clearfix book-collection">

                <div class="row">
                    <c:forEach items="${produtos}" var="produto">
                        <div class="col-md-3">
                            <li><a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}" class="block clearfix">
                                <h2 class="product-title">${produto.titulo}</h2>
                                <img width="143"
                                     height="202"
                                     src="https://cdn.shopify.com/s/files/1/0155/7645/products/java8-featured_large.png?v=1411490181"
                                     alt="Java 8 Prático"
                                     title="Java 8 Prático"/>
                                <small class="buy-button">Compre</small>
                            </a></li>
                        </div>
                    </c:forEach>

                <!-- Fechando aqui -->
                <div class="row" style="margin-top: 20px">
                    <h2 class="cdc-call">Diferenciais da Casa do Código</h2>

                    <ul id="cdc-diferenciais" class="clearfix">
                        <li class="col-left">
                            <h3>E-books sem DRM. Leia onde quiser</h3>
                            <p>
                                <span class="sprite" id="sprite-drm"></span> Nossos e-books não
                                possuem DRM, ou seja, você pode ler em qualquer computador, tablet
                                e smartphone.
                            </p>
                        </li>
                        <li class="col-right">
                            <h3>Autores de renome na comunidade</h3>
                            <p>
                                <span class="sprite" id="sprite-renome"></span> Autores que
                                participam ativamente na comunidade com Open Source, listas de
                                discussão, grupos e mais.
                            </p>
                        </li>
                        <li class="col-left">
                            <h3>Receba atualizações dos e-books</h3>
                            <p>
                                <span class="sprite" id="sprite-atualizacoes"></span> Quando você
                                compra um e-book, automaticamente tem direito às atualizações e
                                correções dele.
                            </p>
                        </li>
                        <li class="col-right">
                            <h3>Livros com curadoria da Caelum</h3>
                            <p>
                                <span class="sprite" id="sprite-caelum"></span> Desenvolvedores
                                experientes que avaliam e revisam os livros constantemente.
                            </p>
                        </li>
                    </ul>
                </div>
            </ul>
        </section>
    </body>
</html>
