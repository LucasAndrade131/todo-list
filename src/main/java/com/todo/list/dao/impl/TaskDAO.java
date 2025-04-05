package com.todo.list.dao.impl;

import com.todo.list.dao.ITaskDAO;
import com.todo.list.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class TaskDAO implements ITaskDAO {

    private final DataSource dataSource;

    @Autowired
    public TaskDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Task save(Task task) {

        String sql;
        if (task.getId() == null) {
            sql = "INSERT INTO task (title, description, completed, categoryId, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?)";
        } else {
            sql = "UPDATE task SET title = ?, description = ?, completed = ?, categoryId = ?, startDate = ?, endDate = ? WHERE id = ?";
        }

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setBoolean(3, task.getCompleted());
            preparedStatement.setInt(4, task.getCategoryId());
            preparedStatement.setTimestamp(5,
                    task.getStartDate() != null ? Timestamp.valueOf(task.getStartDate()) : null);
            preparedStatement.setTimestamp(6,
                    task.getEndDate() != null ? Timestamp.valueOf(task.getEndDate()) : null);

            if (task.getId() != null) {
                preparedStatement.setInt(7, task.getId());
            }

            preparedStatement.executeUpdate();

            if (task.getId() == null) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        task.setId(generatedKeys.getInt(1));
                    }
                }
            }

            return task;

        } catch (SQLException e) {
            throw new RuntimeException("Error saving task", e);
        }
    }
}