package controllers;

import models.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Task> taskList = (List<Task>) session.getAttribute("tasks");

        if (taskList == null) {
            taskList = new ArrayList<>();
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate dueDate = LocalDate.parse(request.getParameter("dueDate"));

        taskList.add(new Task(title, description, dueDate));
        session.setAttribute("tasks", taskList);

        response.sendRedirect("listTasks.jsp");
    }
}
