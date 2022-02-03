<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição do usuário</title>
</head>
<body>
	
	<%@page import="com.crudJspJava.bean.Usuario, com.crudJspJava.dao.UsuarioDao" %>
	<%
		String id = request.getParameter("id");
		Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));
	%>
</body>
</html>