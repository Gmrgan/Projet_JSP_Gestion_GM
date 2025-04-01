<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Ajouter une tâche</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Ajouter une tâche</h1>
        <form action="tasks" method="post">
            <input type="text" name="title" placeholder="Titre" required>
            <textarea name="description" placeholder="Description"></textarea>
            <input type="date" name="dueDate" required>
            <button type="submit">Ajouter</button>
        </form>
    </div>
</body>
</html>
