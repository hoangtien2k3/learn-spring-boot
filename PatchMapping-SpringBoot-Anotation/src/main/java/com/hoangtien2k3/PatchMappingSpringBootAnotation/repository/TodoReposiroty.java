package com.hoangtien2k3.PatchMappingSpringBootAnotation.repository;

import com.hoangtien2k3.PatchMappingSpringBootAnotation.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoReposiroty extends JpaRepository<Todo, Long> {

}
