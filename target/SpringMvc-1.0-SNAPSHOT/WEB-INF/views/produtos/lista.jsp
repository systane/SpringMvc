<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${spring:mvcUrl('HC#home').build()}">Casa do Código</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${spring:mvcUrl('PC#listar').build()}">Lista de Produtos</a></li>
                    <li><a href="${spring:mvcUrl('PC#form').build()}">Cadastro de Produtos</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">
                        <security:authentication property="principal.username"/>
                    </a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>

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
