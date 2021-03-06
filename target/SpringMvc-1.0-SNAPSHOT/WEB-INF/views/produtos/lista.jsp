<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 3/12/2018
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tags:pageTemplate titulo="Livros de Java, Android, iOS, Mobile, e muito mais...">
        <div class="container">
            <h1>Lista de Produtos</h1>

            <div>${sucesso}</div>
            <div>${falha}</div>


            <table class="table table-striped">
               <thead>
                   <tr>
                       <th>Título</th>
                       <th>Descrição</th>
                       <th>Preços</th>
                       <th>Páginas</th>
                       <!-- <th>Data Lançamento</th> -->
                   </tr>
               </thead>
               <tbody>
                   <c:forEach items="${produtos}" var="produto">
                       <tr>
                           <td>
                               <a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>
                           </td>
                           <td>${produto.descricao}</td>
                           <td>${produto.precos}</td>
                           <td>${produto.paginas}</td>
                           <!-- <td>${produto.dataLancamento}</td> -->
                       </tr>
                   </c:forEach>
               </tbody>
           </table>
        </div>

</tags:pageTemplate>
