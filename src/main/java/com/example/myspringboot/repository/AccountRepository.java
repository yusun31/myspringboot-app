package com.example.myspringboot.repository;

import com.example.myspringboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    // username으로 조회하는 finder method 선언
    Account findByUsername(String username);
}
