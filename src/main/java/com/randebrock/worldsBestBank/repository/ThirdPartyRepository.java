package com.randebrock.worldsBestBank.repository;

import com.randebrock.worldsBestBank.model.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, String> {
}
