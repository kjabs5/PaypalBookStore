package com.kishor.paypalbookstore.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.kishor.paypalbookstore.entity.Users;

public interface UsersService {
	
	public Page<Users> users(int pageNumber);

}
