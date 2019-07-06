package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.entity.Address;
import com.lti.entity.User;
import com.lti.service.UserService;

public class UserAddressTest {

	@Test
	public void newUserTest() {
		UserService us=new UserService();
		User u1=new User();
		u1.setName("rahul");
		u1.setEmail("rahul@rahul.com");
		System.out.println(us.add(u1));
	}
	@Test
	public void newAddressTest() {
		UserService us=new UserService();
		Address u1=new Address();
		u1.setCity("Mumbai");
		u1.setPincode(1234);
		u1.setState("Solid");
		u1.setUser(us.fetchById(User.class, 181));
		System.out.println(us.add(u1));
	}
	@Test
	public void addBothTest() {
		UserService us=new UserService();
		User u1=new User();
		Address ua=new Address();
		
		u1.setName("Shaks");
		u1.setEmail("Sh@keel.com");
				
		ua.setCity("Mumbae vaa");
		ua.setPincode(1204);
		ua.setState("Liquid");
		
		u1.setAddress(ua);
		ua.setUser(u1);
		System.out.println(us.add(u1));
	}
	@Test
	public void fetchTest() {
		UserService us=new UserService();
		User u1=us.fetchById(User.class,181);
		Address ua=u1.getAddress();
		System.out.println(u1);
		System.out.println(ua);
	}

}
