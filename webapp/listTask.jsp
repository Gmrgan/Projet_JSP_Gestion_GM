<%@ page import="java.util.List, models.Task" %>
<%
    List<Task> tasks = (List<Task>) session.getAttribute("tasks");
    if (tasks != null) {
        for (Task task : tasks) {
%>
    <div>
        <h3><%= task.getTitle() %></h3>
        <p><%= task.getDescription() %></p>
        <p>Échéance : <%= task.getDueDate() %></p>
    </div>
<%
        }
    }
%>
