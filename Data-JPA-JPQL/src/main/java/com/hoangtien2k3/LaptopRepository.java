package com.hoangtien2k3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

    @Transactional
    @Modifying  // hiểu rằng phương thức đó thay đổi dữ liệu trong cơ sở dữ liệu
    @Query("DELETE FROM Laptop WHERE name = :name") // JPQL
    Integer deleteByName(String name);



    // cách 1:
//    @Query("FROM Laptop WHERE brand = :brand")
//    List<Laptop> getLaptopsByBrand (String brand);

    // cách 2:
    @Query("FROM Laptop WHERE brand = :brand")
    List<Laptop> getLaptopsByBrand (@Param("brand") String brandName);

    // cách 3:
//    @Query("FROM Laptop WHERE brand = ?1")
//    List<Laptop> getLaptopsByBrand (String brandName);



    @Transactional
    @Modifying
    @Query("UPDATE Laptop SET price = :price WHERE name = :name")
    Integer updatePriceByName(BigDecimal price, String name);

}
