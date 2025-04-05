package com.todo.list.service;

import com.todo.list.dto.TaskDTO;

public interface ITaskService {
    TaskDTO createTask(TaskDTO taskDTO);
}
