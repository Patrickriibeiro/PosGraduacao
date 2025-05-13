<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%= response.encodeURL("validacao") %>" method="post">
 Usuário: <input type="text" name="nome" size="10"><br/> 
 Senha: <input type="password" name ="senha" size="10"><br/>
 <input type="submit" value="Enviar">
 </form>
</body>
</html>