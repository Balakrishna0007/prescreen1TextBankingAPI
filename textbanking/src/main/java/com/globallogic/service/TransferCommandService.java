package com.globallogic.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.entity.BankCustomer;
import com.globallogic.entity.Transaction;
import com.globallogic.model.RequestPayload;
import com.globallogic.model.Response;
import com.globallogic.repository.BankRepo;
import com.globallogic.repository.TransactionRepo;

@Service
public class TransferCommandService implements TextBankingCommand
{
	@Autowired
	private TransactionRepo repo;
	
	@Autowired
	private BankRepo bankAccRepo;
	
	@Override
	@Transactional
	public Response execute(RequestPayload request) 
	{
		String message;
		if (bankAccRepo.findById(request.getFromAcc()).isPresent()
				&& bankAccRepo.findById(request.getToAcc()).isPresent())
		{
			BankCustomer fromAcc = bankAccRepo.findById(request.getFromAcc()).get();
			BankCustomer toAcc = bankAccRepo.findById(request.getToAcc()).get();
			int amount = request.getAmount();
			if (fromAcc.getBalance() > amount) 
			{
				Transaction transaction = new Transaction();
				transaction.setAmount(amount);
				transaction.setFromAccountNumber(request.getFromAcc());
				transaction.setToAccountNumber(request.getToAcc());
				transaction.setTransactionDate(new Date());
				
				
				fromAcc.setBalance(fromAcc.getBalance() - amount);
				toAcc.setBalance(toAcc.getBalance() + amount);
				bankAccRepo.save(toAcc);
				bankAccRepo.save(fromAcc);
				repo.save(transaction);
				
				message = "Transfer successful";
			}
			else
			{
				message = "Insufficient balance";
			}
			
		}
		else
		{
			message = "Invalid Account Numbers !!!";
		}
		return new Response(message);
	}
}
