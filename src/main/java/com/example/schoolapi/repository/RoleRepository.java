package com.example.schoolapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.schoolapi.model.Role;
import com.example.schoolapi.model.UserRole;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(UserRole role);
}
