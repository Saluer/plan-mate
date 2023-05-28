package ru.home.api;


import ru.home.model.Task;

import java.util.Collection;

public interface TaskService {
    Collection<Task> findMyTasks(String myName);

    Task save(Task task);

}
