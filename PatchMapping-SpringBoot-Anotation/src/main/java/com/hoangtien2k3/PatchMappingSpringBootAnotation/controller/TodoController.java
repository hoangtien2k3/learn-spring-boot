package com.hoangtien2k3.PatchMappingSpringBootAnotation.controller;

import com.hoangtien2k3.PatchMappingSpringBootAnotation.dto.TodoDto;
import com.hoangtien2k3.PatchMappingSpringBootAnotation.model.Todo;
import com.hoangtien2k3.PatchMappingSpringBootAnotation.repository.TodoReposiroty;
import com.hoangtien2k3.PatchMappingSpringBootAnotation.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoReposiroty todoReposiroty;

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completedTodo(@PathVariable("id") Long todoId) {
        TodoDto updateTodo = todoService.completedTodo(todoId);
        return ResponseEntity.ok(updateTodo);
    }

    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoReposiroty.save(todo);
    }

}
