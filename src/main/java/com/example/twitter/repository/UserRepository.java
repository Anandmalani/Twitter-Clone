package com.example.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twitter.entity.Userr;



@Repository
public interface UserRepository extends JpaRepository<Userr, Integer>{

	boolean existsByUsername(String username);

	Userr findByUsername(String username);


}
