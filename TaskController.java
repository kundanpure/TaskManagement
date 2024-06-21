package com.example.task_management_app.controller;


import com.example.task_management_app.model.Task;
import com.example.task_management_app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String viewTasksPage(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "new_task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update_task";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable(value = "id") Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }
}
