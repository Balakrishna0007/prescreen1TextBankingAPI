package com.globallogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.entity.BankCustomer;
import com.globallogic.model.RequestPayload;
import com.globallogic.model.Response;

@Service
public class BalanceCommandService implements TextBankingCommand 
{
	@Autowired
	private BankCustomerService service;
	
	@Override
	public Response execute(RequestPayload request) 
	{
		Integer accountNumber = request.getAccountNumber();
		BankCustomer customer = service.getBalance(accountNumber);
		if(customer==null)
		{
			return new Response("Invalid AccountNumber!!!");
		}
		return new Response(customer.getBalance()+"");
	}
}
