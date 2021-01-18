package com.globallogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.model.Request;
import com.globallogic.model.RequestPayload;
import com.globallogic.model.Response;
import com.globallogic.service.TransactionService;
import com.globallogic.util.TransactionUtil;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionController 
{

	@Autowired
	private TransactionService service;
	
	@GetMapping(value = "/process")
	public ResponseEntity<Object> process(@RequestBody(required = true) Request request) 
	{
		ResponseEntity<Object> response = null;
		try 
		{
			if (TransactionUtil.isValidRequestPayload(request)) 
			{
				RequestPayload reqPayload = TransactionUtil.constructReqPayload(request);
				Response resp = service.processRequest(reqPayload);
				response = new ResponseEntity<>(resp, HttpStatus.OK);
			}
			else
			{
				response = new ResponseEntity<>("Invalid Request Payload , plese correct your schema!!!!"+getSchema(), HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception ex)
		{
			response = new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	private String getSchema()
	{
		StringBuilder schema = new StringBuilder();
		schema.append("\n1.Balance   Schema (Balance,<AccountNumber>)");
		schema.append("\n2.Transfer  Schema (Transfer,<from account>,<to account><Amount>)");
		schema.append("\n3.Help      Schema (Help)");
		return schema.toString();
	}
}
