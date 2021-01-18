package com.globallogic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankCustomer 
{
	@Id 
	private int accountNumber;
	@Column
	private String customerName;
	@Column
	private int age;
	@Column
	private String accountType;
	@Column
	private int balance;
	
	public BankCustomer()
	{
	}
	
	public BankCustomer(int accountNumber, String customerName, int age, String accountType, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.age = age;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
