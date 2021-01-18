package com.globallogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.model.RequestPayload;
import com.globallogic.model.Response;

@Service
public class TransactionService 
{
	@Autowired
	private ServiceHelper helper;
	
	public Response processRequest(RequestPayload reqPayload)
	{
		TextBankingCommand commandService = helper.getCommandService(reqPayload.getCommandType());
		//Delegation using Command Handler Pattern
		return commandService.execute(reqPayload);
	}
}
