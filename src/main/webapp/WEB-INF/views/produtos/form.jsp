<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lsilva49
  Date: 3/12/2018
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>


<tags:pageTemplate titulo="Livros de Java, Android, iOS, Mobile, e muito mais...">


        <div class="container" style="margin-bottom: 50px; margin-top: 50px">
            <div class="row">
                <div class="col-md-12">
                    <form:form action="${s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto" enctype="multipart/form-data">
                        <div class="row">
                            <div class="form-group col-md-3">
                                <label>Titulo</label>
                                <form:input class="form-control" path="titulo" cssStyle="float: none; border: 1px solid #ced4da"/>
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
                                <form:input class="form-control" path="paginas" cssStyle="float: none; border: 1px solid #ced4da"/>
                                <small class="form-text text-muted">
                                    <form:errors path="paginas" />
                                </small>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-3">
                                <label>Data lançamento</label>
                                <form:input class="form-control" path="dataLancamento" cssStyle="border: 1px solid #ced4da" />
                                <small class="form-text text-muted">
                                    <form:errors path="dataLancamento"/>
                                </small>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
                                <div class="form-group col-md-1">
                                    <label>${tipoPreco}</label>
                                    <form:input class="form-control" cssStyle="border:1px solid #ced4da" path="precos[${status.index}].valor" />
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
        </div>
</tags:pageTemplate>
