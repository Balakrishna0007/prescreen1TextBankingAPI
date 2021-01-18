package com.globallogic.repository;

import org.springframework.data.repository.CrudRepository;

import com.globallogic.entity.BankCustomer;

public interface BankRepo extends CrudRepository<BankCustomer, Integer>
{

}
