package com.globallogic.service;

import com.globallogic.model.RequestPayload;
import com.globallogic.model.Response;

public interface TextBankingCommand 
{
	Response execute(RequestPayload request);
}
