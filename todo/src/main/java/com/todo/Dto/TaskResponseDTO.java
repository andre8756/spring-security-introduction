package com.todo.Dto;

public record TaskResponseDTO(
        Long id,
        String description,
        Boolean completed
) {}
