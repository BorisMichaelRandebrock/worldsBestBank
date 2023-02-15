package com.randebrock.worldsBestBank.repository;

import com.randebrock.worldsBestBank.model.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
