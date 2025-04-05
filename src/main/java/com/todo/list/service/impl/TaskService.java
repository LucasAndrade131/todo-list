package com.todo.list.service.impl;

import com.todo.list.dao.impl.TaskDAO;
import com.todo.list.dto.TaskDTO;
import com.todo.list.mapper.TaskMapper;
import com.todo.list.model.Task;
import com.todo.list.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITaskService {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {

        Task task = TaskMapper.toEntity(taskDTO);
        Task createdTask = taskDAO.save(task);
        return TaskMapper.fromEntity(createdTask);
    }

}
