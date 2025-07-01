<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Liste des employés</title>
</head>
<body>
<h1>Liste des employés</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Département</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="e" items="${employes}">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.department.getName()}</td>
            <td>
                <a href="employes/modifier?id=${e.id}">Modifier</a> |
                <a href="employes/supprimer?id=${e.id}" onclick="return confirm('Supprimer cet employé ?')">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Ajouter un nouvel employé</h2>
<form:form method="post" modelAttribute="employe" action="${pageContext.request.contextPath}/employes">
    Nom: <form:input path="name"/><br/>
    Département:
    <select name="departmentId">
        <option value="">-- Aucun --</option>
        <c:forEach var="dept" items="${departements}">
            <option value="${dept.id}">${dept.name}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="Ajouter"/>
</form:form>

</body>
</html>
