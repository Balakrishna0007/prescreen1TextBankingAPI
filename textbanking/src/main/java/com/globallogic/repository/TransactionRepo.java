package com.globallogic.repository;

import org.springframework.data.repository.CrudRepository;

import com.globallogic.entity.Transaction;

public interface TransactionRepo extends CrudRepository<Transaction, Integer>
{

}
