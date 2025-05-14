<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
 	if(request.getMethod().equals("POST")) {
 		String cpf = request.getParameter("cpf");
 	    out.print("Voce informou o cpf : " + cpf);
 	    out.print("<br/>");
 	} else {
 %>
	<form action="" method="post">
		Informar o cpf : <input type="text" name="cpf" size="15"> <input
			type="submit" value="Enviar">
	</form>
	<% } %>
</body>
</html>