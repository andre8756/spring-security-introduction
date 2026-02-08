package com.todo.Mapper;

import com.todo.Dto.TaskRequestDTO;
import com.todo.Dto.TaskResponseDTO;
import com.todo.Entity.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO taskRequestDTO){
        return Task.builder()
                .description(taskRequestDTO.description())
                .completed(taskRequestDTO.completed())
                .build();
    }

    public static TaskResponseDTO toDTO(Task task){
        return new TaskResponseDTO(
                task.getId(),
                task.getDescription(),
                task.getCompleted()
        );
    }

}
