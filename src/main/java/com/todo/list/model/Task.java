package com.todo.list.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String description;

    private Boolean completed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer categoryId;
}
