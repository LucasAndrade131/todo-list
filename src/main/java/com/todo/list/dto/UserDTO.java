package com.todo.list.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.todo.list.model.User;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Integer  id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;

    @JsonIgnore 
    private List<CategoryDTO> category;

    public static User toEntity(UserDTO UserDTO) {
        if (UserDTO == null) {
            return null;
        }

        final User user = new User();
        user.setId(UserDTO.getId());
        user.setFirstName(UserDTO.getFirstName());
        user.setLastName(UserDTO.getLastName());
        user.setUserName(UserDTO.getUserName());
        user.setEmail(UserDTO.getEmail());

        user.setCategory(UserDTO.getCategory() != null
                ? UserDTO.getCategory().stream()
                .map(CategoryDTO::toEntity)
                .collect(Collectors.toList())
                : Collections.emptyList());

        return user;
    }

    public static UserDTO fromEntity(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .userName(user.getUserName())
                .category(user.getCategory() != null
                        ? user.getCategory().stream()
                        .map(CategoryDTO::fromEntity)
                        .collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }
}
