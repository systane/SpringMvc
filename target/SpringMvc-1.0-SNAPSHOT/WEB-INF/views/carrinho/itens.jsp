<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 5/2/2018
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tags:pageTemplate titulo="Livros de Java, Android, iOS, Mobile, e muito mais...">
        <div class="container">
            <div id="header-content">
                <nav id="main-nav">
                    <ul>
                        <li>
                            <a href="${s:mvcUrl('CCC#itens').build()}">
                                Seu carrinho(${carrinho.quantidade})
                            </a>
                        </li>

                        <li>
                            <a href="/pages/sobre-a-casa-do-codigo">Sobre nós</a>
                        </li>
                    </ul>
                </nav>
            </div>

            <section>
                <h2> Seu carrinho de compras</h2>

                <form action="" method="post">
                    <div class="container">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Item</th>
                                    <th>Preço</th>
                                    <th>Qtd</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carrinho.itens}" var="item">
                                    <tr>
                                        <td>
                                            <img src="">
                                            ${item.produto.titulo}
                                        </td>
                                        <td>${item.preco}</td>
                                        <td><input type="number" min="0" id="quantidade" name="quantidade" value="${carrinho.getQuantidade(item)}"></td>
                                        <td>${carrinho.getTotal(item)}</td>
                                        <td>
                                            <form action="${s:mvcUrl('CCC#remover').arg(0, item.produto.id).arg(1, item.tipoPreco).build() }" method="post">
                                                <input type="image" alt="Excluir" title="Excluir"  value="Excluir">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td>
                                    <form:form action="${s:mvcUrl('PC#finalizar').build()}" method="post">
                                        <input class="btn btn-primary" type="submit" value="Finalizar compra">
                                    </form:form>
                                </td>
                                <td>${carrinho.total}</td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </form>
            </section>
        </div>

</tags:pageTemplate>