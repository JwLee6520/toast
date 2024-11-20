package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankAccountRepositoryTest {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Test
    void findByIdentity() {

    }

    @Test
    void findAllByIdentity() {
        List<BankAccount> bankAccount = this.bankAccountRepository.findAllByIdentity("010105-3000000");
          Assertions.assertEquals(3, bankAccount.size(), "통장 개수가 올바르지 않습니다");
    }
}