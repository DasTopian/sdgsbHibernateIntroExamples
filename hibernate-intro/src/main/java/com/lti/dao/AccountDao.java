package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AccountDao extends GenericDao {
	public <E> List<E> fetchMiniStatement(long acno) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em= emf.createEntityManager();
		//introducing JP-QL/HQL
		Query q= em.createQuery("select bt from BankTransaction bt where bt.account.accno= :ac order by bt.date DESC");
		q.setParameter("ac",acno);
		q.setMaxResults(5);
		List<E> list=q.getResultList();
		return list;
}
public <E> List<E> fetchWithMinBal(double minamt) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em= emf.createEntityManager();
		//introducing JP-QL/HQL
		Query q= em.createQuery("select ac from Account ac where ac.balance > :amt ");
		q.setParameter("amt",minamt);
		List<E> list=q.getResultList();
		return list;
}
public <E> List<E> fetchActiveAccounts(double minamt) {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
	EntityManager em= emf.createEntityManager();
	//introducing JP-QL/HQL
	Query q= em.createQuery("select distinct ac from Account ac inner join ac.transactions tx where tx.amount > :amt");
	q.setParameter("amt",minamt);
	List<E> list=q.getResultList();
	return list;
}

}
