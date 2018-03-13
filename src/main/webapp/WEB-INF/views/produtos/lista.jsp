<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 3/12/2018
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<! DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, Iphone, PHP, Ruby e muito mais - Casa do Código</title>
</head>
<body>
    <h1>Lista de Produtos</h1>

    <div>${sucesso}</div>

   <table>
       <tr>
           <td>Título</td>
           <td>Descrição</td>
           <td>Páginas</td>
           <!--<td></td>-->
       </tr>
       <c:forEach items="${produtos}" var="produto">
           <tr>
               <td>${produto.titulo}</td>
               <td>${produto.descricao}</td>
               <td>${produto.paginas}</td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>
