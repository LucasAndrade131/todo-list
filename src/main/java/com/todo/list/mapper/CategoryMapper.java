package com.todo.list.mapper;

import com.todo.list.dto.CategoryDTO;
import com.todo.list.dto.TaskDTO;
import com.todo.list.dto.UserDTO;
import com.todo.list.model.Category;

public class CategoryMapper {

    public static CategoryDTO fromEntity(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
//                .tasks(
//                        category.getTasks() != null
//                                ? category.getTasks().stream()
//                                .map(TaskDTO::fromEntity)
//                                .toList()
//                                : null
//                )
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setUser(UserDTO.toEntity(categoryDTO.getUser()));
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        return category;
    }

}
