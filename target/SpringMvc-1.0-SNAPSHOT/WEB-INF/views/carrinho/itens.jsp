<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 5/2/2018
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tags:pageTemplate titulo="Seu carrinho de compras">

    <jsp:attribute name="extraScripts">
        <script>
            console.log("Finalização de compra de ${carrinho.quantidade} itens");
        </script>
    </jsp:attribute>

    <jsp:body>
        <div class="container" style="margin-top: 60px; margin-bottom: 60px">
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
                                <td colspan="4">
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
    </jsp:body>
</tags:pageTemplate>