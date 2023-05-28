package ru.home.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Task {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private Instant modifiedAt;

    @Column
    @NotNull
    private String name;

    @Column
    private String description;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "creator_name")
    @NotNull
    private String creatorName;

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
