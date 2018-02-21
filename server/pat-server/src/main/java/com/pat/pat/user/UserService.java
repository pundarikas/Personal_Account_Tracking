package com.pat.pat.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public UserModel findByUsername(String username) {
		return this.userRepository.findByUserName(username);
	}
	
	public UserModel signupUser(UserModel userSignupInfo) {

		if (this.findByUsername(userSignupInfo.getUserName()) != null) {
			throw new IllegalArgumentException("This userName is already used.");
		}

		// encrypt password
		//PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/*if (userSignupInfo.getPassword() != null) {
			userSignupInfo.setPassword(passwordEncoder.encode(userSignupInfo.getPassword()));
		}*/

		UserModel user = new UserModel();
		List<String> userRoles = new ArrayList<>();
		userRoles.add("USER");
		user.setRoles(userRoles);
		user.setUserName(userSignupInfo.getUserName());
		user.setPassword(userSignupInfo.getPassword());
		UserModel savedUser = this.userRepository.save(user);
		System.out.println(" New user signedup with " + savedUser.getUserName() );
		
		return savedUser;
	}
	
	public boolean login(UserModel userModel) {
		UserModel user = this.userRepository.findByUserNameAndPassword(
				userModel.getUserName(), userModel.getPassword());
		
		if (user != null) {
			return true;
		} else {
			return false;
		}

	}
}
