package com.todo.Controller;

import com.todo.Dto.TaskRequestDTO;
import com.todo.Dto.TaskResponseDTO;
import com.todo.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponseDTO create(@RequestBody @Valid TaskRequestDTO dto){
        return taskService.create(dto);
    }

    @GetMapping
    public List<TaskResponseDTO> findAll(){
        return taskService.findAll();
    }

}
