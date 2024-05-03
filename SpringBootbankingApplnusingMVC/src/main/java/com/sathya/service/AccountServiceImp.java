package com.sathya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.model.Account;
import com.sathya.repository.AccountRepo;
@Service
public class AccountServiceImp implements AccountService {
	@Autowired
    private AccountRepo repo;
	@Override
	public Account saveAccount(Account account) {
		Account acc=repo.save(account);
		return acc;
	}
	@Override
	public Account getRecord(int acc_no)
	{
		Account a1=repo.findById(acc_no).get();
		return a1;
	}
	@Override
	public Account depositAmount(int acc_no,String name ,String password, double amount) {
		Account acc=repo.findById(acc_no).get();
		 int accountNo=acc.getAcc_no();
		 String pass=acc.getPassword();
		 String nameofaccholder=acc.getName();
		 double amount1=acc.getAmount();
		 if(acc_no==accountNo&&pass.equals(password)&&nameofaccholder.equals(name))
		 {
			 amount1=acc.getAmount()+amount;
		 }
		 acc.setAmount(amount1);
		 repo.save(acc);
		 return acc;
	}
	@Override
	public Account withdrawAmount(int acc_no, String name, String password, double amount) {
	
		Account acc=repo.findById(acc_no).get();
		 int accountNo=acc.getAcc_no();
		 String pass=acc.getPassword();
		 String nameofaccholder=acc.getName();
		 double amount1=acc.getAmount();
		 if(acc_no==accountNo&&pass.equals(password)&&nameofaccholder.equals(name))
		 {
			if(amount1<amount)
			{
				 return null;
			}
			else
			{
				amount1=amount1-amount;
			}
		 }
		 acc.setAmount(amount1);
		 repo.save(acc);
		 return acc;
	}
	@Override
	public Account transferAmount(int acc_no, String name, String password, int acc_no1, double amount) {
	    Account acc = repo.findById(acc_no).get();
	    Account acc1 = repo.findById(acc_no1).get();

	    if (acc != null && acc1 != null) {
	        if (acc.getPassword().equals(password) && acc.getName().equals(name)) {
	            double sourceAccountBalance = acc.getAmount();

	            // Check if the source account has sufficient balance
	            if (sourceAccountBalance >= amount) {
	                // Perform the transfer
	                double targetAccountBalance = acc1.getAmount() + amount;
	                acc.setAmount(sourceAccountBalance - amount);
	                acc1.setAmount(targetAccountBalance);

	                repo.save(acc);
	                repo.save(acc1);

	                return acc1;
	            } 
	            else
	            {
	                return null;
	            }
	        }
	    }
		return null;
	}
	@Override
	public String closeAccount(int acc_no, String name, String password) {
		
		Account acc=repo.findById(acc_no).get();
		if(acc!=null)
		{
		    if(acc.getAcc_no()==acc_no&&acc.getName().equals(name)&&acc.getPassword().equals(password))
		    {
		    	 acc.setAmount(0);
		    	 repo.save(acc);
	             return "Account closed successfully!";
	        }
	    }

	        return "Failed to close account. Please check your credentials.";
	    }
	}
	
