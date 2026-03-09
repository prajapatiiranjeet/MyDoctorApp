package com.incapp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incapp.models.User;
import com.incapp.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public boolean register(User user) {
		return userRepo.register(user);
	}
	
	public User updateUser(User user) {
		return userRepo.updateUser(user);
	}
	public boolean updatePhoto(String email, byte[] photo) {
		return userRepo.updatePhoto(email, photo);
	}

	public boolean updatePassword(String email, String oldPassword, String newPassword) {
		return userRepo.updatePassword(email,oldPassword,newPassword);
	}

	public boolean updatePassword(String email, String newPassword) {
		return userRepo.updatePassword(email,newPassword);
	}

	public User getUser(String email) {
		return userRepo.getUser(email);
	}
	public byte[] getPhoto(String email) {
		return userRepo.getPhoto(email);
	}
}
