package com.SpringBoot.dbdemo.repository;

import com.SpringBoot.dbdemo.entity.StoreInformation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreInformationRepository extends CrudRepository<StoreInformation, Integer> {
    List<StoreInformation> findByStoreName(String name);
    List<StoreInformation> findByStorePhoneNumber(String phoneNumber);
    List<StoreInformation> findByStoreDetail(String detail);
}
