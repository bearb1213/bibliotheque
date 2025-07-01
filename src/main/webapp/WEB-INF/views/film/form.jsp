<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>Liste</h1>
    <table border="1">
        <thead>
            
            <tr>
                <th>Titre</th>
                <th>Date de sortie</th>
                <th>Catégories</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="film" items="${films}">
                <tr>
                    <td>${film.titre}</td>
                    <td>${film.dateSortie}</td>
                    <td>
                        <c:forEach var="cat" items="${film.categories}" varStatus="catStatus">
                            ${cat.nom}<c:if test="${!catStatus.last}">, </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="delete?id=${film.id}">del</a> - 
                        <a href="update?id=${film.id}">modif</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h1>Insert Film</h1>
    <form action="insert" method="post">
        <h2>Titre</h2>
        <input type="text" name="titre" required />

        <h2>Date de sortie</h2>
        <input type="date" name="date_sortie" required />

        <h2>Catégories</h2>
        <div>
            <c:forEach var="cat" items="${Categories}">
                <div>
                    <input type="checkbox" name="categories" value="${cat.id}" />
                    <label>${cat.nom}</label>
                </div>
            </c:forEach>
        </div>

        <input type="submit" value="Save" />
    </form>
</body>
</html>
