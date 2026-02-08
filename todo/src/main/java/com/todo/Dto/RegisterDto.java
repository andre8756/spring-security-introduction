package com.todo.Dto;

import com.todo.Enum.Role;

public record RegisterDto(String login, String password, Role role) {
}
