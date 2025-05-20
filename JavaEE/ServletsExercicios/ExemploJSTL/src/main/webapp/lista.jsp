<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:out value="Exemplo de JSTL"></c:out>

<c:set var="aluno" value="${param.nome}"></c:set>

<c:out value="${aluno}">
	Nenhum nome informado.
 </c:out>
 
 
 <jsp:useBean id="carro" class="com.patrickriibeiro.javabeans.Automovel"></jsp:useBean>
 
<h1>Lista de Veiculos</h1>

<c:forEach var="item"  items="${carro.listaVeiculos}">
    Marca: <c:out value="${item.marca}"/>
    Modelo: <c:out value="${item.modelo}"/>
    Ano: <c:out value="${item.ano}"/>
</c:forEach> 