package com.estefania.taskmanager.model;

import com.estefania.taskmanager.Enum.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;

    @NotBlank(message = "title is required")
    private String title;
    private String description;
    private Boolean completed;

    @NotNull(message = "priority is required")
    private Priority priority;
    private LocalDate createdAt;


}
