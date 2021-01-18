package com.globallogic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.entity.BankCustomer;
import com.globallogic.repository.BankRepo;

@Service
public class BankCustomerService 
{
	@Autowired
	private BankRepo repo;

	public BankCustomer getBalance(Integer accountNumber)
	{
		Optional<BankCustomer> customer = repo.findById(accountNumber);
		if(customer.isPresent())
		{
			return customer.get();
		}
		return null;
	}
}
