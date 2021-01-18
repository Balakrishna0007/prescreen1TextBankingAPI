package com.globallogic.util;

import java.util.Arrays;
import java.util.List;

import com.globallogic.model.Request;
import com.globallogic.model.RequestPayload;

public class TransactionUtil 
{
	public static boolean isValidRequestPayload(Request request)
	{
		//Due to Time constraint i am hard-coding commands
		List<String> commands = Arrays.asList("Balance","Transfer","Help");
		if(request!=null && request.getInputs()!=null)
		{
			String command = request.getInputs().get(0);
			if (commands.contains(command) && (command.equalsIgnoreCase("Balance") && request.getInputs().size() == 2)
					|| (command.equalsIgnoreCase("Transfer") && request.getInputs().size() == 4)
					|| (command.equalsIgnoreCase("Help"))) 
			{
				return true;
			}
		}
		return false;
	}
	public static RequestPayload constructReqPayload(Request request)
	{
		String command = request.getInputs().get(0);
		RequestPayload payload = new RequestPayload();
		if(command.equalsIgnoreCase("Balance"))
		{
			payload.setCommandType("Balance");
			payload.setAccountNumber(Integer.parseInt(request.getInputs().get(1)));
		}
		else if(command.equalsIgnoreCase("Transfer"))
		{
			payload.setCommandType("Transfer");
			payload.setFromAcc(Integer.parseInt(request.getInputs().get(1)));
			payload.setToAcc(Integer.parseInt(request.getInputs().get(2)));
			payload.setAmount(Integer.parseInt(request.getInputs().get(3)));
		}
		else if(command.equalsIgnoreCase("Help"))
		{
			payload.setCommandType("Help");
		}
		return payload;
	}

}
