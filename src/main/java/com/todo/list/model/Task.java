package com.todo.list.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String description;

    private Boolean completed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer categoryId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
