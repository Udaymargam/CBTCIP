package com.sathya.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sathya.model.Account;
import com.sathya.service.AccountServiceImp;
@Controller
public class AccountController {
	@Autowired
	private AccountServiceImp service;

  @RequestMapping("/")
  public String getHome() 
  {
	  return "home";
  }
  @RequestMapping("/newaccount")
  public String register() 
  {
	  return "registeraccount";
  }
  @RequestMapping("/register")
  public String accountRegister(Account account) 
  {
	  service.saveAccount(account);
	  return "success";
  }
  @RequestMapping("/balance")
  public String getBalance()
  {
	  return "balance";
  }
  @RequestMapping("/getbalance")
  public String getDetails(int acc_no,ModelMap model)
  {
	  model.put("account",service.getRecord(acc_no));
	  return "accountdetails";
  }
  @RequestMapping("/deposit")
  public String getDeposit() 
  {
	  return "deposit";
  }
  @RequestMapping("/depositamount")
  public String depositAmount(@RequestParam int acc_no,@RequestParam String name,@RequestParam String password,@RequestParam double amount,ModelMap model) 
  {
	  model.put("acc", service.depositAmount(acc_no, name, password, amount));
	  model.put("amount", amount) ; 
	  return "depositresult";
  }
  @RequestMapping("/withdraw")
  public String getWithdraw() 
  {
	  return "withdraw";
  }
  @RequestMapping("/withdrawamount")
  public String WithdrawAmount(@RequestParam int acc_no,@RequestParam String name,@RequestParam String password,@RequestParam double amount,ModelMap model) 
  {
	  Account acc = service.withdrawAmount(acc_no, name, password, amount);

	  if (acc != null) 
	  {
		  model.put("acc", acc);
		  model.put("amount", amount);
		  return "withdrawresult";
	  } 
	  else 
	  {
		  return "insufficientbalance";
	  }
  }
  @RequestMapping("/transfer")
  public String transfer()
  {
	  return "transfer";
  }
  @RequestMapping("/transferamount")
  public String getTransferResult(@RequestParam int acc_no, @RequestParam String name,
          @RequestParam String password, @RequestParam int acc_no1,
          @RequestParam double amount, ModelMap model) {
      Account acc = service.transferAmount(acc_no, name, password, acc_no1, amount);

      if (acc != null) 
      {
          model.put("acc", service.getRecord(acc_no));
          model.put("acc1", service.getRecord(acc_no1));
          model.put("amount", amount);
          return "transferresult";
      } 
      else
      {
          return "invaliddetails";
      }
  }
  @RequestMapping("/aboutus")
  public String getAboutUs() 
  {
	  return "aboutus";
  }
  @RequestMapping("/closeaccount")
  public String getCloseaccount()
  {
	  return "closeaccount";
  }
  @RequestMapping("/closeA/C")
  public String closeAccount(@RequestParam int acc_no,@RequestParam String name,@RequestParam String password,ModelMap model)
  {
	  String result=service.closeAccount(acc_no, name, password);
	  model.put("result", result);
	  return "closeaccresult";
  }

  
}
