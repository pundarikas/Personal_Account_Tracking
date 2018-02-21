package com.pat.pat.expense;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

	public List<Expense> findByMonth(String month);
	
}
