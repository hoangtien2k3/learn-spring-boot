package com.hoangtien2k3.springboot.repository;

import com.hoangtien2k3.springboot.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
