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
	<form:form action="../asociaMembroProjeto" modelAttribute="membro">
		<spring:message code="nome.projeto"/><form:input path="projeto" />
		<br>
		<spring:message code="nome.membro"/><form:input path="nome"/>
		<br>
		<form:button><spring:message code="botao.alterar"/></form:button>
	</form:form>
</body>
</html>