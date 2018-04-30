<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
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
    <div class="row">
        <div class="col-md-12">
            <form:form action="${s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto" enctype="multipart/form-data">
                <div class="row">
                    <div class="form-group col-md-3 ">
                        <label>Titulo</label>
                        <form:input class="form-control" path="titulo"/>
                        <small class="form-text text-muted">
                            <form:errors path="titulo" />
                        </small>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label>Descrição</label>
                        <form:textarea class="form-control" path="descricao" rows="3"/>
                        <small class="form-text text-muted">
                            <form:errors path="descricao" />
                        </small>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label>Páginas</label>
                        <form:input class="form-control" path="paginas"/>
                        <small class="form-text text-muted">
                            <form:errors path="paginas" />
                        </small>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label>Data lançamento</label>
                        <form:input class="form-control" path="dataLancamento" />
                        <small class="form-text text-muted">
                            <form:errors path="dataLancamento"/>
                        </small>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
                        <div class="form-group col-md-1">
                            <label>${tipoPreco}</label>
                            <form:input class="form-control" path="precos[${status.index}].valor"/>
                            <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}"/>
                        </div>
                    </c:forEach>
                </div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label>Sumário</label>
                        <input name="sumario" type="file">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <button class="btn btn-primary" type="submit">Cadastrar</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
