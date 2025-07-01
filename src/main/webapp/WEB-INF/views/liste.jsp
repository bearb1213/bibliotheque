<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Départements</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h2>Bonjour bienvenu dans le spring MVC</h2>
    <div class="container mt-5">
        <h2>Liste des Départements</h2>
        
        <!-- Formulaire d'ajout -->
        <form method="post" action="${pageContext.request.contextPath}/departements" class="mb-4">
            <div class="input-group">
                <input type="text" name="name" class="form-control" placeholder="Nom du département" required>
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </div>
        </form>
        
        <!-- Tableau des départements -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${departements}" var="dep">
                    <tr>
                        <td>${dep.id}</td>
                        <td>${dep.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/departements/supprimer?id=${dep.id}" 
                               class="btn btn-danger btn-sm">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
