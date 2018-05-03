<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 4/26/2018
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>${produto.titulo} - Casa do Código</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </head>

    <body class="produto">
        <div class="container">
            <div id="header-content">
                <nav id="main-nav">
                    <ul>
                        <li>
                            <a href="/carrinho">
                                Seu carrinho(${carrinho.quantidade})
                            </a>
                        </li>

                        <li>
                            <a href="/pages/sobre-a-casa-do-codigo">Sobre nós</a>
                        </li>
                    </ul>
                </nav>
            </div>


            <article id="${produto.id}">
                <div id="product-overview">
                    <header>
                        <img>
                        <h1 id="product-title"${produto.titulo}></h1>

                        <p id="book-description">${produto.descricao}</p>
                    </header>
                </div>
            </article>


            <section id="buy-options">
                <form:form servletRelativeAction="/carrinho/add" method="post"> <!--  A TAG C:URL PERMITE LINKAR PÁGINAS SEM PERDER O CONTEXTO DA APLICAÇÃO -->
                    <ul>
                        <input type="hidden" value="${produto.id}" name="produtoId"/>
                        <c:forEach items="${produto.precos}" var="preco">
                            <li class="buy-option">
                                <input type="radio" name="tipoPreco" class="variant-radio"
                                       id="tipo" value="${preco.tipo}"  checked="checked"  />
                                <label  class="variant-label">
                                        ${preco.tipo}
                                </label>
                                <small class="compare-at-price">R$ 39,90</small>
                                <p class="variant-price">${preco.valor}</p>
                            </li>
                        </c:forEach>
                    </ul>

                    <button type="submit" title="Compre agora '${produto.titulo}' !">Comprar</button>

                    <%--&lt;%&ndash;<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">&ndash;%&gt; Campo utilizado para validar requisições com o csrf token--%>
                </form:form>
            </section>


            <section>
               <h3>
                   E muito mais... <a href="/pages/sumario">Veja o sumário</a>
               </h3>
            </section>


            <section>
                <h2>Dados do livro:</h2>
                <p>Número de páginas: <span>${produto.paginas}</span></p>
                <p>Data de publicação:
                    <span><fmt:formatDate pattern="dd/MM/yyyy" value="${produto.dataLancamento.time}"></fmt:formatDate></span>
                </p>
            </section>
        </div>


    </body>
</html>