package com.hoangtien2k3.DeleteMappingSpringBootAnotation.repository;

import com.hoangtien2k3.DeleteMappingSpringBootAnotation.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}