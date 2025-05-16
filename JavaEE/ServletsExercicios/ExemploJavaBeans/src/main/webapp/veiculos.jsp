<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="carro" class="com.patrickriibeiro.javabeans.Automovel" />

<jsp:setProperty property="marca" name="carro" value="Fiat" />
<jsp:setProperty property="modelo" name="carro" value="Siena" />
<jsp:setProperty property="ano" name="carro" value="2010" />

<h1>Dados do Veiculo</h1>

<p>
	Marca:
	<jsp:getProperty property="marca" name="carro" />
	Modelo:
	<jsp:getProperty property="modelo" name="carro" />
	Ano:
	<jsp:getProperty property="ano" name="carro" />
	<b> <jsp:getProperty property="mensagem" name="carro" />
	</b>
</p>

