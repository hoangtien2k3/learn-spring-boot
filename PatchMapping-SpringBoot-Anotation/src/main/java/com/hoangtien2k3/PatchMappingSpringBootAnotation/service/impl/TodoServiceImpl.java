package com.hoangtien2k3.PatchMappingSpringBootAnotation.service.impl;

import com.hoangtien2k3.PatchMappingSpringBootAnotation.dto.TodoDto;
import com.hoangtien2k3.PatchMappingSpringBootAnotation.exception.ResourceNotFoundException;
import com.hoangtien2k3.PatchMappingSpringBootAnotation.model.Todo;
import com.hoangtien2k3.PatchMappingSpringBootAnotation.repository.TodoReposiroty;
import com.hoangtien2k3.PatchMappingSpringBootAnotation.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    TodoReposiroty todoReposiroty;

    private TodoDto mapToToDto(Todo todo) {
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todoDto.getId());
        todoDto.setTitle(todoDto.getTitle());
        todoDto.setDescription(todoDto.getDescription());
        todoDto.setCompleted(todoDto.isCompleted());
        return todoDto;
    }


    @Override
    public TodoDto completedTodo(Long id) {

        Todo todo = todoReposiroty
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo no found with id: " + id));
        // TODO: 8/8/2023
        todo.setCompleted(Boolean.TRUE); // SET TRUE (completed)
        
        Todo updateTodo = todoReposiroty.save(todo);
        
        return mapToToDto(updateTodo);
    }
}
