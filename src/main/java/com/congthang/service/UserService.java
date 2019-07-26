package com.congthang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congthang.entity.User;
import com.congthang.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public boolean checkLogin(User user) {
		return userRepository.checkLogin(user);
	}
	public void save(User user) {
		userRepository.save(user);
	}
}
