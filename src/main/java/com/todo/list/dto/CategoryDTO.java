package com.todo.list.dto;

import com.todo.list.model.Category;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Integer id;
    private String name;
    private String description;
    private UserDTO user;
    private List<TaskDTO> tasks;

    public CategoryDTO(Integer id) {
        this.id = id;
    }

}
