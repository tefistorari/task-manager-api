package com.estefania.taskmanager.model;

import com.estefania.taskmanager.Enum.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title is required")
    private String title;

    private String description;

    private Boolean completed;

    @NotNull(message = "priority is required")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDate createdAt;


}
