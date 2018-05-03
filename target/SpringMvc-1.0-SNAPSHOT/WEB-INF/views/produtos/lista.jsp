<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</head>
<body>
    <h1 style="text-align: center">Lista de Produtos</h1>

    <div>${sucesso}</div>
    <div>${falha}</div>

    <div class="container">
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
                           <a href="${spring:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>
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
