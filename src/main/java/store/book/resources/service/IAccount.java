package store.book.resources.service;

import store.book.resources.model.Account;

public interface IAccount {

    Account CheckAccount(String email, String password);
}
