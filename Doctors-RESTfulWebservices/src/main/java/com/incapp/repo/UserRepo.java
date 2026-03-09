package com.incapp.repo;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incapp.models.Doctor;
import com.incapp.models.DoctorDetails;
import com.incapp.models.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class UserRepo {
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public boolean register(User user) {
		Session session= entityManager.unwrap(Session.class);
		User u=session.get(User.class,user.getEmail());
		if(u==null) {
			session.persist(user);
			return true;
		}else {
			return false;
		}
		
	}
	
	public List<User> get() {
		Session session= entityManager.unwrap(Session.class);
		List<User> list=session.createQuery("from User",User.class).list();
		return list;
	}
	
	public User getByEmail(String email) {
		Session session= entityManager.unwrap(Session.class);
		User user=session.get(User.class, email);
		return user;
	}
	
	@Transactional
	public User updateUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		User u = session.get(User.class, user.getEmail());
		if(u!=null) {
			u.setPhone(user.getPhone());
			u.setName(user.getName());
			u.setDob(user.getDob());
			u.setGender(user.getGender());
			session.persist(u);
		}
		return u;
	}
	
	@Transactional
	public boolean updatePhoto(String email, byte[] photo) {
		Session session= entityManager.unwrap(Session.class);
		User user = session.get(User.class, email);
		if(user==null) {
			return false;
		}else {
			user.setPhoto(photo);
			session.persist(user);
			return true;
		}
	}
	@Transactional
	public boolean updatePassword(String email, String oldPassword, String newPassword) {
		Session session= entityManager.unwrap(Session.class);
		User user = session.get(User.class, email);
		if(user!=null && user.getPassword().equals(oldPassword)) {
			user.setPassword(newPassword);
			session.persist(user);
			return true;
		}else {
			return false;
		}
	}
	@Transactional
	public boolean updatePassword(String email, String newPassword) {
		Session session= entityManager.unwrap(Session.class);
		User user = session.get(User.class, email);
		if(user!=null) {
			user.setPassword(newPassword);
			session.persist(user);
			return true;
		}else {
			return false;
		}
	}

	public User getUser(String email) {
		Session session= entityManager.unwrap(Session.class);
		User user = session.get(User.class, email);
		return user;
	}
	public byte[] getPhoto(String email) {
		Session session= entityManager.unwrap(Session.class);
		User user=session.get(User.class, email);
		return user.getPhoto();
	}
}
