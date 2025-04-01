<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Ajouter une tâche</title>
</head>
<body>
    <form action="tasks" method="post">
        <input type="text" name="title" placeholder="Titre" required>
        <textarea name="description" placeholder="Description"></textarea>
        <input type="date" name="dueDate" required>
        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
