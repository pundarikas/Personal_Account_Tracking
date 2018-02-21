package com.pat.pat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public UserModel signupNewUser(@RequestBody  UserModel userModel) {
		System.out.println(userModel.toString());
		return this.userService.signupUser(userModel);
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody UserModel userModel) {
		boolean b=this.userService.login(userModel);;
		
		return b;
	}
}
