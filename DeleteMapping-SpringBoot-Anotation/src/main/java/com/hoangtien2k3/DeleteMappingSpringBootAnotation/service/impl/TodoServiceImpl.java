package com.hoangtien2k3.DeleteMappingSpringBootAnotation.service.impl;

import com.hoangtien2k3.DeleteMappingSpringBootAnotation.exception.ResourceNotFoundException;
import com.hoangtien2k3.DeleteMappingSpringBootAnotation.model.Todo;
import com.hoangtien2k3.DeleteMappingSpringBootAnotation.repository.TodoRepository;
import com.hoangtien2k3.DeleteMappingSpringBootAnotation.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        todoRepository.deleteById(id);
    }
}
