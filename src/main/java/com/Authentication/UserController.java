package com.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/nishant")
  public String nishant() {
	  return "Welcome";
  }
  
  @PostMapping("/register")
  public UserDetails createUser(@RequestBody UserDetails user){
    return this.userService.save(user);
  }
}
