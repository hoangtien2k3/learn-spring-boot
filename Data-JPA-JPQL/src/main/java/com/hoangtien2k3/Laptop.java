package com.hoangtien2k3;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tbl_laptops")
@Data
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // INT NOT NULL PRIMARY KEY AUTO_INCREMENT

    private String name; // VARCHAR(255) NOT NULL

    private String brand; // VARCHAR(255) NOT NULL

    private String description; // VARCHAR(255) NOT NULL

    private BigDecimal price; // DOUBLE(10, 2) NOT NULL

    @Column(name="created_at")
    private Date createdAt; // DATE NOT NULL
}
