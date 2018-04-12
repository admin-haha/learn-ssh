package com.system.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.system.po.Users;
import com.system.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	private ModelMap checkUserLogin(HttpServletResponse response,String account,String password,ModelMap context) {
		Users vo = usersRepository.queryByAccountAndPassword(account, password);
		
		
		return context;
	}
}
