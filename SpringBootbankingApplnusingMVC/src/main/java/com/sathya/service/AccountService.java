package com.sathya.service;
import com.sathya.model.Account;
public interface AccountService 
{
      public Account saveAccount(Account account);
      public Account getRecord(int acc_no);
      public Account depositAmount(int acc_no,String name,String password,double amount);
      public Account withdrawAmount(int acc_no,String name,String password,double amount);
      public Account transferAmount(int acc_no,String name,String password,int acc_no1,double amount);
      public String closeAccount(int acc_no,String name,String password);
}
