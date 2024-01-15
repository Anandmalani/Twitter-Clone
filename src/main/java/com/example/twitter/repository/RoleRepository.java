package com.example.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.twitter.entity.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRoleName(String string);


}
