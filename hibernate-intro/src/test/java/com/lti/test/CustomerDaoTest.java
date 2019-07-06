package com.lti.test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;

import oracle.sql.DATE;

public class CustomerDaoTest {

	@Test
	public void addTest() {
		try {
		Customer c=new Customer();
		c.setName("Shakeel");
		c.setEmail("shkmhd@abc.com");
		Date d;
		d = new SimpleDateFormat("dd/MM/yyyy").parse("27/10/1997");
		c.setDob(d);
		c.setCity("KozhiKode");
		CustomerDao dao=new CustomerDao();
		dao.add(c);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void fetchTest() {
		CustomerDao dao=new CustomerDao();
		Customer c=new Customer();
		c=dao.fetch(1);
		System.out.println(c);
	}
	@Test
	public void testUpdate() {
		
		CustomerDao dao=new CustomerDao();
		Customer c=dao.fetch(1);
		c.setCity("Kollam");
			System.out.println(dao.update(c));
		
		
	}

}
