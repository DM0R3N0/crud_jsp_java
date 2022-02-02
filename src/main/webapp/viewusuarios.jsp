<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualiza��o de usu�rios</title>
</head>
<body>
	
	<%@ page import="com.crudJspJava.dao.UsuarioDao, com.crudJspJava.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
	<h1>Listagem de usu�rios</h1>	
	
	<%
	List<Usuario> list = UsuarioDao.getAllUsuarios();
	request.setAttribute("list", list);
	%>
	
	<table>
		<tr><th>ID</th><th>Nome</th><th>Password</th><th>Email</th><th>Sexo</th><th>Pa�s</th></tr>
		
		<c:forEach items="${list}" var="usuario">
			<tr>
				<td>${usuario.getId()}</td>
				<td>${usuario.getNome()}</td>
				<td>${usuario.getPassword()}</td>
				<td>${usuario.getSexo()}</td>
				<td>${usuario.getPais()}</td>
			</tr>		
		</c:forEach>		
	</table>

</body>
</html>