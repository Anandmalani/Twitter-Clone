package com.example.twitter.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.twitter.entity.Userr;
import com.example.twitter.repository.UserRepository;



@Service
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Write logic to fetch customer from DB
        Userr user = userRepository.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + username));

        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

	
}
