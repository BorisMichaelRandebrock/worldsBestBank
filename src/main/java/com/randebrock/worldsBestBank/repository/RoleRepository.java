package com.randebrock.worldsBestBank.repository;

import com.randebrock.worldsBestBank.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}