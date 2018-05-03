<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 3/12/2018
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
        <div class="container">
            <h1>Lista de Produtos</h1>

            <div>${sucesso}</div>
            <div>${falha}</div>


            <table class="table table-striped">
               <thead>
                   <tr>
                       <th>Título</th>
                       <th>Descrição</th>
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
                           <td>${produto.paginas}</td>
                           <!-- <td>${produto.dataLancamento}</td> -->
                       </tr>
                   </c:forEach>
               </tbody>
           </table>
        </div>
    </body>
</html>
