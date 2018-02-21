package com.pat.pat.income;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeRepository extends MongoRepository<Income, String> {
	public List<Income> findByMonth(String month);
}
