<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:forEach items="${membrosProjeto}" var="membroProj">
	   <c:out value="${projeto}-${membroProj.nome}-${membroProj.cargo}"/> 
    </c:forEach>
</body>
</html>