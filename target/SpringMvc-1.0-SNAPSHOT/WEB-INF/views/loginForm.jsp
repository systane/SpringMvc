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
        <c:url value="/resources/css" var="cssPath"></c:url>
        <c:url value="/resources/js" var="jsPath"></c:url>

        <link rel="stylesheet" href="${cssPath}/bootstrap.css">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
        <script src="${jsPath}/bootstrap.js"></script>
    </head>
    <body>
        <h1>Login</h1>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form:form servletRelativeAction="/login" method="post">
                        <div class="row">
                            <div class="form-group col-md-3 ">
                                <label>Email</label>
                                <input class="form-control" type="text" name="username"/> <!-- username para o spring validar -->
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-3">
                                <label>Senha</label>
                                <input class="form-control" type="password" name="password"/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Logar</button>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
