package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.BankTransaction;
import com.lti.service.AccountService;

public class AccountServicesTest {

	@Test
	public void openAccTest() {
	
		AccountService s=new AccountService();
		Account ac=new Account();
		ac.setName("Shakeel");
		ac.setBalance(1000);
		ac.setType("Savings");
		s.openAccount(ac);
	}
	@Test
	public void withdrawTest() {
	
		AccountService s=new AccountService();
		s.withdraw(129, 101);
			
	}
	@Test
	public void depositTest() {
	
		AccountService s=new AccountService();
		Account ac=new Account();
		s.deposit(129, 1000);
		System.out.println(s.checkBalance(129));
	}
	@Test
	public void transferTest() {
		AccountService s=new AccountService();
		s.transfer(133, 129, 100);
		System.out.println(s.checkBalance(129));
		System.out.println(s.checkBalance(133));
	}
	@Test
	public void statementTest() {
		AccountService as =new AccountService();
		List<BankTransaction> tx=as.generateStatement(129);
		for(BankTransaction bt:tx)
			System.out.println(bt);
	}
	@Test
	public void atleastTest() {
		AccountService as =new AccountService();
		List<Account> lac=as.minBalance(5000);
		for(Account ac:lac)
			System.out.println(ac);
	}
	@Test
	public void activeAccountTest() {
		AccountService as =new AccountService();
		List<Account> lac=as.activeAccounts(100);
		for(Account ac:lac)
			System.out.println(ac);
	//	lac.forEach(System.out::println);
	}
}
