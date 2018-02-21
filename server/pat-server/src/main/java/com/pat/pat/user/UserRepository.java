package com.pat.pat.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {

	public UserModel findByUserName(String userName);
	public UserModel findByUserNameAndPassword(String userName,String password);
}
