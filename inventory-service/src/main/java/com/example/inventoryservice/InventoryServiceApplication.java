package com.example.inventoryservice;
import com.example.inventoryservice.model.Inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.inventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(InventoryServiceApplication.class, args);

	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args->{
			Inventory inventory=new Inventory();
			inventory.setSkuCode("ipv");
			inventory.setQuantity(10);
			
			Inventory inventory1=new Inventory();
			inventory1.setSkuCode("google");
			inventory1.setQuantity(0);
			
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
	
	

}
