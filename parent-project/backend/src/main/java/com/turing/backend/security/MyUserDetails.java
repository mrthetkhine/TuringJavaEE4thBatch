package com.turing.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.turing.backend.model.User;
import com.turing.backend.repository.UserRepository;




@Service
public class MyUserDetails implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  final User user = userRepository.findByUsername(username); 
	  System.out.println("Find by username "+username +" Got user "+user);
	  if (user == null) {
	      throw new UsernameNotFoundException("User '" + username + "' not found");
	    }
	  return org.springframework.security.core.userdetails.User//
		        .withUsername(username)//
		        .password(user.getPassword())//
		        .authorities(user.getRoles())//
		        .accountExpired(false)//
		        .accountLocked(false)//
		        .credentialsExpired(false)//
		        .disabled(false)//
		        .build();

  	}

   

}
