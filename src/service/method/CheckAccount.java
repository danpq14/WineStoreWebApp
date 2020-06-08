package service.method;

import model.Account;

import java.util.List;

public class CheckAccount {
    public static Account execute(String userName, String password, List<Account> accountList) {
        Account account = null;
        for (Account account_ : accountList) {
            if (userName.equalsIgnoreCase(account_.getUsername())) {
                if (password.equalsIgnoreCase(account_.getPassword())) {
                    account = account_;
                    break;
                }
            }
        }
        return account;
    }
}
