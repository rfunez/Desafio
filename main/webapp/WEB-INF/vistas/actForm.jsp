<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="../atualiza" modelAttribute="projeto">
		<spring:message code="nome.projeto"/><form:input path="nome" />
		<br>
		<spring:message code="nome.gerente"/><form:input path="gerente"/>
		<br>
		<spring:message code="data.inicio"/><form:input path="dataInicio"/>
		<br>
		<spring:message code="data.fim"/><form:input path="dataTermino"/>
		<br>
		<spring:message code="projeto.orcamento"/><form:input path="orcamento"/>
		<br>
		<spring:message code="projeto.previsao"/><form:input path="prevTermino"/>
		<br>		
		<spring:message code="projeto.descricao"/><form:input path="descricao"/>
		<br>
		<spring:message code="projeto.status"/><form:input path="status"/>
		<br>
		<form:button><spring:message code="botao.alterar"/></form:button>
	</form:form>
</body>
</html>