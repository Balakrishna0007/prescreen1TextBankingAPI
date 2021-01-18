package com.globallogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.entity.BankCustomer;
import com.globallogic.repository.BankRepo;

@SpringBootApplication
public class TextbankingApplication implements CommandLineRunner
{
	@Autowired
	private BankRepo repo;
	
	public static void main(String[] args)
	{
		SpringApplication.run(TextbankingApplication.class, args);
	}

	//for seed data
	@Override
	public void run(String... args) throws Exception 
	{
		BankCustomer cust1 = new BankCustomer(1234500, "Bala", 32, "savings", 35000);
		BankCustomer cust2 = new BankCustomer(1234501, "Mahi", 30, "salary", 45000);
		BankCustomer cust3 = new BankCustomer(1234502, "Raja", 27, "savings", 5000);
		
		repo.save(cust1);
		repo.save(cust2);
		repo.save(cust3);
	}
	
}
