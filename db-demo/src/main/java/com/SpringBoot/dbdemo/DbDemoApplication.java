package com.SpringBoot.dbdemo;

import com.SpringBoot.dbdemo.entity.StoreInformation;
import com.SpringBoot.dbdemo.repository.StoreInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbDemoApplication implements CommandLineRunner {

	@Autowired
	StoreInformationRepository storeInformationRepository;

	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		StoreInformation storeInformationOne = new StoreInformation
				("Amazon", "All type of bags are avaiable here", "xxxxx");
		StoreInformation storeInformationTwo = new StoreInformation
				("Flipkart", "All type of books are avaiable here", "yyyyy");
		StoreInformation storeInformationThird = new StoreInformation
				("Meesho", "All fashion items are avaiable here", "zzzzz");
		StoreInformation storeInformationFour = new StoreInformation
				("Myntra", "All fashion iteams are avaiable here", "aaaaa");

		storeInformationRepository.save(storeInformationOne);
		storeInformationRepository.save(storeInformationTwo);
		storeInformationRepository.save(storeInformationThird);
		storeInformationRepository.save(storeInformationFour);

		storeInformationRepository.findByStoreName("Amazon").forEach(
				val -> System.out.println(val)
		);

		storeInformationRepository.findByStoreDetail("All fashion iteams are avaiable here").forEach(
				val -> System.out.println(val)
		);

		storeInformationRepository.findByStorePhoneNumber("yyyyy").forEach(
				val -> System.out.println(val)
		);

		storeInformationRepository.findById(2).ifPresent(
				val -> System.out.println(val)
		);
	}
}
