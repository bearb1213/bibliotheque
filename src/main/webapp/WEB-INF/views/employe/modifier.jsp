<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Modifier employé</title>
</head>
<body>
<h1>Modifier l'employé</h1>

<form:form method="post" modelAttribute="employe" action="${pageContext.request.contextPath}/employes/modifier">
    <form:hidden path="id"/>

    Nom: <form:input path="name"/><br/>
    
    Département:
    <select name="departmentId">
        <option value="">-- Aucun --</option>
        <c:forEach var="dept" items="${departements}">
            <option value="${dept.id}" <c:if test="${dept.id == employe.department.id}">selected</c:if>>
                ${dept.name}
            </option>
        </c:forEach>
    </select><br/>

    <input type="submit" value="Enregistrer"/>
</form:form>

<a href="${pageContext.request.contextPath}/employes">Retour à la liste</a>
</body>
</html>
