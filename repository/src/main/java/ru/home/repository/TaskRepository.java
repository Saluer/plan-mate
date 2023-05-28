package ru.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.model.Task;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    Collection<Task> findAllByCreatorName(String creatorName);
}
