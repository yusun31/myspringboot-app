package com.example.myspringboot.repository;

import com.example.myspringboot.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud() throws Exception {
        // 1. insert
        // Account 객체 생성
        Account account = new Account();
        // 값 저장
        account.setUsername("spring2");
        account.setPassword("1234");
        //등록요청
        Account savedAccount = accountRepository.save(account);
        System.out.println("ID: " + savedAccount.getId());
        System.out.println("username: " + savedAccount.getUsername());
    }
}
