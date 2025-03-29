package com.todo.list.dto;

import com.todo.list.model.Task;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

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

    public static Task fromEntity(TaskDTO taskDTO) {
        final Task task = new Task();
                task.setId(taskDTO.getId());
                task.setTitle(taskDTO.getTitle());
                task.setDescription(taskDTO.getDescription());
                task.setCompleted(taskDTO.getCompleted());
                task.setStartDate(taskDTO.getStartDate());
                task.setCategoryId(taskDTO.getCategory().getId());

                return task;
        }

    public static TaskDTO fromEntity(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.getCompleted())
                .startDate(task.getStartDate())
                .category(task.getCategoryId() != null ? new CategoryDTO(task.getCategoryId()) : null)
                .build();
    }

}
