package com.globallogic.model;

public class RequestPayload 
{
	private String commandType;
	private Integer accountNumber;
	private Integer fromAcc;
	private Integer toAcc;
	private Integer amount;
	public String getCommandType() {
		return commandType;
	}
	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Integer getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(Integer fromAcc) {
		this.fromAcc = fromAcc;
	}
	public Integer getToAcc() {
		return toAcc;
	}
	public void setToAcc(Integer toAcc) {
		this.toAcc = toAcc;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
