package com.randebrock.worldsBestBank.repository;

import com.randebrock.worldsBestBank.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
