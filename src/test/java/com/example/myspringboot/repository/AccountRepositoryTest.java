package com.example.myspringboot.repository;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountRepositoryTest {
//    @Autowired
//    AccountRepository accountRepository;
//
//    @Test
//    @Disabled
//    public void crud() throws Exception {
//        // 1. insert
//        // Account 객체 생성
//        Account account = new Account();
//        // 값 저장
//        account.setUsername("spring");
//        account.setPassword("1234");
//        //등록요청
//        Account savedAccount = accountRepository.save(account);
//        System.out.println("ID: " + savedAccount.getId());
//        System.out.println("username: " + savedAccount.getUsername());
//    }
//
//    @Test
//    public void finder() throws Exception {
//        // ctrl + alt + v
//        Optional<Account> optional = accountRepository.findById(1L);
//        if(optional.isPresent()) {
//            Account account = optional.get();
//            System.out.println("Account " + account.getUsername());
//        }
//
//        Account acct = accountRepository.findById(10L).orElse(new Account());
//        System.out.println("Account " + acct.getUsername());
//
//        // OrElseGet(Supplier sup)
//        // Supplier의 추상메서드 T get()
//        Account acct2 = accountRepository.findById(2L).orElseGet(() -> new Account(""));
//        System.out.println("acct2.getUsername() = " + acct2.getUsername());

        //Account acct3 = accountRepository.findById(3L).orElseThrow(() -> new RuntimeException("Account Not Found"));
//    }
}
