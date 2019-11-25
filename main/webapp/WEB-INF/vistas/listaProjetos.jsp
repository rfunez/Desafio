<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
	    <tr><th>Nome Projeto</th><th>Data Ini</th><th>Data fim</th><th>Duraçao</th><th>Gerente</th><th>Orçamento</th><th>Descriçao</th><th>Status</th><th>Operaçoes</th></tr>	
		<c:forEach items="${listaProjetos}" var="projeto">
			<tr>
			    <td>${projeto.nome}</td>
			    <td>${projeto.dataInicio}</td>
			    <td>${projeto.dataTermino}</td>
			    <td>${projeto.prevTermino}</td>
			    <td>${projeto.gerente}</td>
			    <td>${projeto.orcamento}</td>
			    <td>${projeto.descricao}</td>
			    <td>${projeto.status}</td>
			    <td><a href="atualizaForm/${projeto.nome}">Atualizar</a>
			        <a href="remove/${projeto.nome}">Remover</a>
			        <a href="asociar/${projeto}">Asociar Funcionario</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>