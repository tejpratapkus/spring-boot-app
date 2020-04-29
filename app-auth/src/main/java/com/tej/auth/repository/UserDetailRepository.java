package com.tej.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tej.auth.modal.User;

public interface UserDetailRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String name);
}
