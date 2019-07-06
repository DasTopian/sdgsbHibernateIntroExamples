package com.lti.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.BankTransaction;
import com.lti.entity.Customer;

public class AccountService {

	public void openAccount(Account ac) {
		AccountDao dao=new AccountDao();
		dao.save(ac);
		//code to send emails after registration goes here!
	}
	public void withdraw(long accno,double amount) {
		AccountDao dao=new AccountDao();
		Account ac= dao.fetchById(Account.class, accno);
		BankTransaction bt=new BankTransaction();
		if(checkBalance(accno)>=amount)
		{
			bt.setDate(new Date());
			bt.setType("Withdraw");
			bt.setAmount(amount);
			ac.setBalance(ac.getBalance()-amount);
			dao.save(ac);
			bt.setAccount(ac);
			dao.save(bt);
		}
		
	
			else
				System.out.println("Mafi Fullose");
		
	}
	public void deposit(long accno,double amount) {
		AccountDao dao=new AccountDao();
		Account ac= dao.fetchById(Account.class, accno);
		BankTransaction bt=new BankTransaction();
		
			bt.setDate(new Date());
			bt.setType("Deposit");
			bt.setAmount(amount);
			ac.setBalance(ac.getBalance()+amount);
			dao.save(ac);
			bt.setAccount(ac);
			dao.save(bt);
	}
	public void transfer(long frmacno, long toacno, double amount ) {
		AccountDao dao=new AccountDao();
	
		if(checkBalance(frmacno)>=amount)
		{
			BankTransaction bt1=new BankTransaction();
			Account facc= dao.fetchById(Account.class, frmacno);
			bt1.setDate(new Date());
			bt1.setType("Transfered");
			bt1.setAmount(amount);
			facc.setBalance(facc.getBalance()-amount);
			dao.save(facc);
			bt1.setAccount(facc);
			dao.save(bt1);
			
			BankTransaction bt2=new BankTransaction();
			Account tacc= dao.fetchById(Account.class, toacno);
			bt2.setDate(new Date());
			bt2.setType("Money Recvd");
			bt2.setAmount(amount);
			tacc.setBalance(tacc.getBalance()+amount);
			dao.save(tacc);
			bt2.setAccount(tacc);
			dao.save(bt2);
		}
			else
			System.out.println("Mafi Fullose");		
}
	public double checkBalance(long acno) {
		AccountDao dao=new AccountDao();
		return (dao.fetchById(Account.class, acno).getBalance());
	}
	public List<BankTransaction> generateStatement(long acno)
	{
		AccountDao adao=new AccountDao();
		return(adao.fetchMiniStatement(acno));
	}
	
	public List<Account> minBalance(double minamt)
	{
		AccountDao adao=new AccountDao();
		return(adao.fetchWithMinBal(minamt));
	}
	public List<Account> activeAccounts(double minamt)
	{
		AccountDao adao=new AccountDao();
		return(adao.fetchActiveAccounts(minamt));
	}
	
}
