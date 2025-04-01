<%@ page import="java.util.List, models.Task" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Liste des Tâches</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Liste des tâches</h1>
        <a href="addTask.jsp">Ajouter une tâche</a>
        <a href="index.jsp">Retour à l'accueil</a>

        <%
            List<Task> tasks = (List<Task>) session.getAttribute("tasks");
            if (tasks != null && !tasks.isEmpty()) {
                for (Task task : tasks) {
        %>
            <div class="task <%= task.isCompleted() ? "completed" : "" %>">
                <h3><%= task.getTitle() %></h3>
                <p><%= task.getDescription() %></p>
                <p>Échéance : <%= task.getDueDate() %></p>
            </div>
        <%
                }
            } else {
        %>
            <p>Aucune tâche enregistrée.</p>
        <%
            }
        %>
    </div>
</body>
</html>
