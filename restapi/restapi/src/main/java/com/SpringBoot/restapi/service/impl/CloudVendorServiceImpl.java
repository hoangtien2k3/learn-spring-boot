package com.SpringBoot.restapi.service.impl;

import com.SpringBoot.restapi.exception.CloudVendorNotFoundException;
import com.SpringBoot.restapi.model.CloudVendor;
import com.SpringBoot.restapi.repository.CloudVendorRepository;
import com.SpringBoot.restapi.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        // more business logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        // more logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
//        if (cloudVendorRepository.findById(cloudVendorId).isEmpty()) {
//            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
//        }
//        return cloudVendorRepository.findById(cloudVendorId).get();

        return cloudVendorRepository.findById(cloudVendorId)
                .orElseThrow(() -> new CloudVendorNotFoundException
                        ("Requested Cloud Vendor does not exist")
                );
    }


    @Override
    public List<CloudVendor> getAllCloudVendors() {
        // more business logic
        return cloudVendorRepository.findAll();
    }
}
