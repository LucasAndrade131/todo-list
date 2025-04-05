package com.todo.list.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Integer id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String categoryName;

    private CategoryDTO category;

}
