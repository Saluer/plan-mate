package ru.home.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Task {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column(name = "created_at")
    private Instant createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Task task = (Task) o;

        return id != null && id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return 1976597858;
    }
}
