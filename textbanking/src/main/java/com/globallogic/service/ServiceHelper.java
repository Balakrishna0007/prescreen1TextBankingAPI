package com.globallogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceHelper 
{
	@Autowired
	private BalanceCommandService balanceService;
	@Autowired
	private TransferCommandService transferService;
	@Autowired
	private HelpCommandService helpService;
	
	public TextBankingCommand getCommandService(String command)
	{
		if(command.equalsIgnoreCase("Balance"))
		{
			return balanceService;
		}
		else if(command.equalsIgnoreCase("Transfer"))
		{
			return transferService;
		}
		else if(command.equalsIgnoreCase("Help"))
		{
			return helpService;
		}
		return null;
	}

}
