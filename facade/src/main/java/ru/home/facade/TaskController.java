package ru.home.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.repository.TaskRepository;

@RestController
public class TaskController {
    private final static Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void getMyTasks() {
        taskRepository.findAll();
    }

}
