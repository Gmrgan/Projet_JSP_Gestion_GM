package controllers;

import models.Task;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Task> tasks = (ArrayList<Task>) session.getAttribute("tasks");

        if (tasks == null) {
            tasks = new ArrayList<>();
            session.setAttribute("tasks", tasks);
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Ajout d'une tâche
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String dueDate = request.getParameter("dueDate");
            tasks.add(new Task(title, description, dueDate, false));
        } else if ("delete".equals(action)) {
            // Suppression d'une tâche
            int index = Integer.parseInt(request.getParameter("index"));
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
            }
        } else if ("complete".equals(action)) {
            // Marquer une tâche comme terminée
            int index = Integer.parseInt(request.getParameter("index"));
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).setCompleted(true);
            }
        }    
        }

        response.sendRedirect("listTasks.jsp");
    }
}
