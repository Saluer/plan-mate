package ru.home.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.home.model.Task;
import ru.home.repository.TaskRepository;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final static Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Task> getMyTasks() {
        return taskRepository.findAll();
    }

    @PutMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Task save(Task task) {
        return taskRepository.save(task);
    }

}
