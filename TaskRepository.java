package com.example.task_management_app.repository;




import com.example.task_management_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Custom query methods can be added if needed
}
