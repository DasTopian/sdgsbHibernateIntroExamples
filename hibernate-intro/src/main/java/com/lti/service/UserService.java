package com.lti.service;

import com.lti.dao.UserAddressDao;

public class UserService {
	public <E> E add(E in) {
		UserAddressDao uadao=new UserAddressDao();
		return uadao.save(in);
	}
	public <E> E fetchById(Class <E> c,Object Id) {
		UserAddressDao uadao=new UserAddressDao();
		return uadao.fetchById(c, Id);
	}

}
