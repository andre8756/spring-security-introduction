package com.todo.Service;

import com.todo.Dto.TaskRequestDTO;
import com.todo.Dto.TaskResponseDTO;
import com.todo.Entity.Task;
import com.todo.Mapper.TaskMapper;
import com.todo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponseDTO create(TaskRequestDTO dto){
        Task task = TaskMapper.toEntity(dto);
        Task savedTask = taskRepository.save(task);

        return TaskMapper.toDTO(savedTask);
    }

    public TaskResponseDTO update(Long id, TaskResponseDTO dto){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada."));

        task.setDescription(dto.description());
        task.setCompleted(dto.completed());

        Task updateTask = taskRepository.save(task);
        return TaskMapper.toDTO(updateTask);
    }

    public void delete(Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada."));

        taskRepository.delete(task);
    }

    public TaskResponseDTO findById(Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        return TaskMapper.toDTO(task);
    }

    public List<TaskResponseDTO> findAll(){

        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toDTO)
                .toList();
    }

}
