package com.globallogic.service;

import org.springframework.stereotype.Service;

import com.globallogic.model.RequestPayload;
import com.globallogic.model.Response;

@Service
public class HelpCommandService implements TextBankingCommand
{
	@Override
	public Response execute(RequestPayload request)
	{
		String availableCommands = "1.Balance\n2.Transfer\n3.Help";
		return new Response(availableCommands);
	}
}
