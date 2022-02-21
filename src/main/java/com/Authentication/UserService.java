package com.Authentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepository userRepository;
  
  PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
    this.passwordEncoder = new BCryptPasswordEncoder();
  }

  public UserDetails save(UserDetails user){
	  String encodedPassword = this.passwordEncoder.encode(user.getPassword());
	  user.setPassword(encodedPassword);
    return this.userRepository.save(user);
  }

}