package com.hoangtien2k3.PatchMappingSpringBootAnotation.service;

import com.hoangtien2k3.PatchMappingSpringBootAnotation.dto.TodoDto;

public interface TodoService {
    TodoDto completedTodo(Long id);
}
