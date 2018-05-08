<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 3/12/2018
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tags:pageTemplate titulo="Produto não encontrado">

    <section class="container" >
        <h2>Erro genérico acontecendo!!!</h2>


        <!--
            Mensagem: ${exception.message}
            <c:forEach items="${exception.stackTrace}" var="stack">
                ${stk}
            </c:forEach>
        -->

    </section>
</tags:pageTemplate>

