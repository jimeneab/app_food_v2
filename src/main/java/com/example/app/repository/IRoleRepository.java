package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
