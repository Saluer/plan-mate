package ru.home.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
public class Task {

    @Id
    private UUID id;

    private String name;

    @Column(name = "created_at")
    private Instant createdAt;
}
