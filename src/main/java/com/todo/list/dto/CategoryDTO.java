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


    public static Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setUser(UserDTO.toEntity(categoryDTO.getUser()));
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        return category;
    }

    public static CategoryDTO fromEntity(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .tasks(
                        category.getTasks() != null
                                ? category.getTasks().stream()
                                .map(TaskDTO::fromEntity)
                                .toList()
                                : null
                )
                .build();
    }

}
