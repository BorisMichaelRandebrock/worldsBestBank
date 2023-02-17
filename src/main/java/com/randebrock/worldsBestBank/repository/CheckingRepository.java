package com.randebrock.worldsBestBank.repository;

import com.randebrock.worldsBestBank.model.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
