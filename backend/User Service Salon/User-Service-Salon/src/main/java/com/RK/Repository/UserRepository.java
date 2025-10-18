package com.RK.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RK.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}
