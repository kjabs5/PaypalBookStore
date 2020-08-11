package com.kishor.paypalbookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kishor.paypalbookstore.dao.UsersRepository;
import com.kishor.paypalbookstore.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {
    
	@Autowired
	private UsersRepository usersRepository;
	
	
	@Override
	public Page<Users> users(int pageNumber) {
		Pageable pageable=PageRequest.of(pageNumber-1,5);
		return usersRepository.findAll(pageable);
	}

}
