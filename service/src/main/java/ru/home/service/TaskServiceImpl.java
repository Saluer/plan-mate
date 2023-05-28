package ru.home.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.home.api.TaskService;
import ru.home.model.Task;
import ru.home.model.TaskStatus;
import ru.home.repository.TaskRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Collection<Task> findMyTasks(String myName) {
        return taskRepository.findAllByCreatorName(myName);
    }

    @Override
    public Task save(Task task) {
        task.setCreatorName(SecurityContextHolder.getContext().getAuthentication().getName());
        task.setStatus(TaskStatus.READY_TO_GO);
        return taskRepository.save(task);
    }
}
