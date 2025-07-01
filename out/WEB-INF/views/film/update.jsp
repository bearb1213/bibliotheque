<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Film</title>
</head>
<body>
    <h1>Modifier le film</h1>

    <form action="update" method="post">
        <input type="hidden" name="id" value="${film.id}" />

        <label>Titre :</label><br>
        <input type="text" name="titre" value="${film.titre}" required /><br><br>

        <label>Date de sortie :</label><br>
        <input type="date" name="date_sortie" value="${film.dateSortie}" required /><br><br>

        <label>Catégories :</label><br>
        <div>
            <c:forEach var="cat" items="${Categories}">
                <c:set var="checked" value="false" />
                <c:forEach var="c" items="${film.categories}">
                    <c:if test="${c.id == cat.id}">
                        <c:set var="checked" value="true" />
                    </c:if>
                </c:forEach>
                <div>
                    <input type="checkbox" name="categories" value="${cat.id}" 
                        <c:if test="${checked}">checked</c:if> />
                    ${cat.nom}
                </div>
            </c:forEach>

        </div><br>

        <input type="submit" value="Mettre à jour" />
    </form>
</body>
</html>
