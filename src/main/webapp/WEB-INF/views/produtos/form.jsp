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
    <form action="/SpringMvc/produtos" method="post">
        <div>
            <label>Titulo</label>
            <input  name="titulo" type="text">
        </div>
        <div>
            <label>Descrição</label>
            <textarea name="descricao" rows="10" cols="20"></textarea>
        </div>
        <div>
            <label>Páginas</label>
            <input name="paginas" type="text">
        </div>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
