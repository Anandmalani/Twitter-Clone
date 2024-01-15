package com.example.twitter.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.twitter.dto.UserDto;
import com.example.twitter.entity.Role;
import com.example.twitter.entity.Userr;
import com.example.twitter.repository.RoleRepository;
import com.example.twitter.repository.UserRepository;



@Service
public class SignUpService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private  PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	
	public UserDto userToUserdto(Userr user) {
		return modelMapper.map(user, UserDto.class);		
	}
	public Userr userdtoToUser(UserDto userdto) {
		return modelMapper.map(userdto, Userr.class);	
		
	}


	public UserDto createUser(UserDto userdto) {
		if (userRepository.existsByUsername(userdto.getUsername())) {
            return null;
        }
		 String hashPassword = passwordEncoder.encode(userdto.getPassword());
	       userdto.setPassword(hashPassword);
	       Userr user=userdtoToUser(userdto);
	       
	       //set role
	       List<Role> roles = new ArrayList<>();
	    	Role userRole = roleRepository.findByRoleName("USER");
	    	if (userRole == null) {
	    	    userRole = new Role();
	    	    userRole.setRoleName("USER");
	    	    
	    	}
	    	roles.add(userRole);
	    	user.setRoles(roles);
	    	userRepository.save(user);
	    	UserDto userdto1=userToUserdto(user);

      
		 return userdto1;

	}

	


}

