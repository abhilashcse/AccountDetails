package com.accountDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountDetails.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

	public Account findByUsername(String username);
}
