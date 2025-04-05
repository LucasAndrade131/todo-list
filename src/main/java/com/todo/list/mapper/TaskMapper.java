package com.todo.list.mapper;

import com.todo.list.dto.CategoryDTO;
import com.todo.list.dto.TaskDTO;
import com.todo.list.model.Task;

public class TaskMapper {

    public static TaskDTO fromEntity(Task task) {
        //fromEntity converts a Task entity to a TaskDTO
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.getCompleted())
                .startDate(task.getStartDate())
                .category(task.getCategoryId() != null ? new CategoryDTO(task.getCategoryId()) : null)
                .build();
    }

    public static Task toEntity(TaskDTO taskDTO) {
        final Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.getCompleted());
        task.setStartDate(taskDTO.getStartDate());
        task.setCategoryId(taskDTO.getCategory().getId());

        return task;
    }
}
