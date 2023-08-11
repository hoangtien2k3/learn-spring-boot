package com.hoantien2k3.springbootsearchrestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity     // annotation is used to mark the class as a persistent Java class.
@Table(name = "products")
public class Product {  // Create JPA Entity
    @Id     // annotation is used to define the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // annotation is used to define the primary key generation strategy. In the above case, we have declared the primary key to be an Auto Increment field.
    private Long id;
    private String sku;
    private String name;
    private String description;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdate;
}
