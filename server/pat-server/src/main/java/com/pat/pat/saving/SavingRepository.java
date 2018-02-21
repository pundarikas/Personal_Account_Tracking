package com.pat.pat.saving;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SavingRepository extends MongoRepository<Saving, String> {
	public Saving findByMonth(String month);

}
