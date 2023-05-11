package Demowebservice.accountservice.service;

import Demowebservice.accountservice.model.AccountDTO;

import java.util.List;

public interface AccountService {
    void add(AccountDTO accountDTO);
    void update(AccountDTO accountDTO);
    void updatePassword(AccountDTO accountDTO);
    void delete(Long id);
    List<AccountDTO> getAll();
    AccountDTO getOne(Long id);
}
