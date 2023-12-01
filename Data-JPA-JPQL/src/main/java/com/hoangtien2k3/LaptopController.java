package com.hoangtien2k3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LaptopController {
    @Autowired
    private LaptopRepository lRepo;

    @DeleteMapping("/laptops/delete/{name}")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        return new ResponseEntity<>(lRepo.deleteByName(name) + " record(s) deleted", HttpStatus.OK);
    }

    @GetMapping("/laptops/{brand}")
    public List<Laptop> getListOfLaptopsByBrand(@PathVariable String brand) {
        return lRepo.getLaptopsByBrand(brand);
    }


    @PutMapping("/laptops/update/{price}/{name}")
    public ResponseEntity<String> updatePriceByName(@PathVariable BigDecimal price, @PathVariable String name) {
        return new ResponseEntity<String>(lRepo.updatePriceByName(price, name) + " record(s) updated.", HttpStatus.OK);
    }


}
