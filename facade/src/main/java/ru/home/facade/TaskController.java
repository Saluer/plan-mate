package ru.home.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.home.api.TaskService;
import ru.home.model.Task;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @PreAuthorize("not anonymous")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Task> getMyTasks(@NotNull Authentication authentication) {
        return taskService.findMyTasks(authentication.getName());
    }

    @PreAuthorize("not anonymous and hasAuthority('SAVE')")
    @PutMapping(path = "save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

}
