package com.incapp.repo;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.incapp.models.Doctor;
import com.incapp.models.DoctorAvail;
import com.incapp.models.DoctorDetails;
import com.incapp.models.DoctorNotAvail;
import com.incapp.models.DoctorOnline;
import com.incapp.models.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class DoctorRepo {
	@Autowired
	private EntityManager entityManager;

	public List<Doctor> getDoctors() {
		Session session= entityManager.unwrap(Session.class);
		return session.createQuery("from Doctor", Doctor.class).list();
	}

	public List<Doctor> getDoctorsBySpeciality(String speciality) {
		Session session= entityManager.unwrap(Session.class);
		return session.createQuery("select d from Doctor d where d.speciality = :speciality",Doctor.class)
				.setParameter("speciality", speciality)
				.list();
	}
	public List<Doctor> getDoctors(String state,String city,String speciality) {
		Session session= entityManager.unwrap(Session.class);
		return session.createQuery("select d from Doctor d where d.state = :state and d.city = :city and d.speciality = :speciality",Doctor.class)
				.setParameter("state", state).setParameter("city", city).setParameter("speciality", speciality)
				.list();
	}
	@Transactional
	public boolean register(Doctor doctor) {
		Session session= entityManager.unwrap(Session.class);
		Doctor d=session.get(Doctor.class,doctor.getEmail());
		if(d==null) {
			DoctorDetails doctorDetails=new DoctorDetails();
			doctor.setDoctorDetails(doctorDetails);
			DoctorAvail doctorAvail=new DoctorAvail();
			doctor.setDoctorAvail(doctorAvail);
			session.persist(doctorDetails);
			session.persist(doctorAvail);
			session.persist(doctor);
			return true;
		}else {
			return false;
		}
	}
	public Doctor getDoctor(String email) {
		Session session= entityManager.unwrap(Session.class);
		return session.get(Doctor.class,email);
	}
	@Transactional
	public Doctor updateDocAvail(String email, DoctorAvail doctorAvail) {
		Session session = entityManager.unwrap(Session.class);
		Doctor doctor = session.get(Doctor.class, email);
		if(doctor!=null) {
			DoctorAvail da = doctor.getDoctorAvail();
			da.setMax_eve_apmt(doctorAvail.getMax_eve_apmt());
			da.setMax_mor_apmt(doctorAvail.getMax_mor_apmt());
			da.setMon_eve(doctorAvail.getMon_eve());
			da.setMon_mor(doctorAvail.getMon_mor());
			da.setTue_eve(doctorAvail.getTue_eve());
			da.setTue_mor(doctorAvail.getTue_mor());
			da.setWed_eve(doctorAvail.getWed_eve());
			da.setWed_mor(doctorAvail.getWed_mor());
			da.setThu_eve(doctorAvail.getThu_eve());
			da.setThu_mor(doctorAvail.getThu_mor());
			da.setFri_eve(doctorAvail.getFri_eve());
			da.setFri_mor(doctorAvail.getFri_mor());
			da.setSat_eve(doctorAvail.getSat_eve());
			da.setSat_mor(doctorAvail.getSat_mor());
			da.setSun_eve(doctorAvail.getSun_eve());
			da.setSun_mor(doctorAvail.getSun_mor());
			session.persist(da);
		}
		return doctor;
	}
	@Transactional
	public Doctor updateDoctor(Doctor doctor) {
		Session session = entityManager.unwrap(Session.class);
		Doctor d = session.get(Doctor.class, doctor.getEmail());
		if(d!=null) {
			d.setArea(doctor.getArea());
			d.setCity(doctor.getCity());
			d.setName(doctor.getName());
			d.setState(doctor.getState());
			d.setSpeciality(doctor.getSpeciality());
			
			DoctorDetails dd = d.getDoctorDetails();
			dd.setDob(doctor.getDoctorDetails().getDob());
			dd.setExperience(doctor.getDoctorDetails().getExperience());
			dd.setGender(doctor.getDoctorDetails().getGender());
			dd.setPhone(doctor.getDoctorDetails().getPhone());
			dd.setQualification(doctor.getDoctorDetails().getQualification());
			
			session.persist(dd);
			session.persist(d);
		}
		return d;
	}
	@Transactional
	public boolean updateDoctorPhoto(String email, byte[] photo) {
		Session session= entityManager.unwrap(Session.class);
		Doctor doctor = session.get(Doctor.class, email);
		if(doctor==null) {
			return false;
		}else {
			DoctorDetails dd = doctor.getDoctorDetails();
			dd.setPhoto(photo);
			session.persist(dd);
			return true;
		}
	}
	@Transactional
	public boolean addDocNotAvail(DoctorNotAvail doctorNotAvail) {
		Session session= entityManager.unwrap(Session.class);
		List<DoctorNotAvail> list = session
				.createQuery("select d from DoctorNotAvail d where d.email = :email and d.doc_date = :doc_date", DoctorNotAvail.class)
				.setParameter("doc_date", doctorNotAvail.getDoc_date())
				.setParameter("email", doctorNotAvail.getEmail()).list();
		if(list.isEmpty()) {
			session.persist(doctorNotAvail);
			return true;
		}else {
			return false;
		}
	}

	public byte[] getDoctorPhoto(String email) {
		Session session= entityManager.unwrap(Session.class);
		Doctor doctor=session.get(Doctor.class, email);
		return doctor.getDoctorDetails().getPhoto();
	}
	
	
	@Transactional
	public boolean updatePassword(String email, String newPassword) {
		Session session= entityManager.unwrap(Session.class);
		Doctor doctor = session.get(Doctor.class, email);
		if(doctor!=null) {
			doctor.setPassword(newPassword);
			session.persist(doctor);
			return true;
		}else {
			return false;
		}
	}

	public List<DoctorNotAvail> getDocNotAvail(String email) {
		Session session= entityManager.unwrap(Session.class);
		List<DoctorNotAvail> list = session
				.createQuery("select d from DoctorNotAvail d where d.email = :email", DoctorNotAvail.class)
				.setParameter("email", email).list();
		return list;
	}

	@Transactional
	public boolean cancelDocNotAvail(int id) {
		Session session= entityManager.unwrap(Session.class);
		DoctorNotAvail dna=session.get(DoctorNotAvail.class, id);
		if(dna!=null) {
			session.remove(dna);
			return true;
		}else {
			return false;
		}
		
	}
	public DoctorOnline getDoctorOnline(String email) {
		Session session= entityManager.unwrap(Session.class);
		return session.get(DoctorOnline.class,email);
	}
	@Transactional
	public DoctorOnline doctorOnline(String email, String speciality) {
		Session session= entityManager.unwrap(Session.class);
		DoctorOnline doctorOnline=session.get(DoctorOnline.class,email);
		if(doctorOnline==null) {
			String roomID=(int)Math.round(Math.random()*10000)+"";
			doctorOnline=new DoctorOnline();
			doctorOnline.setDocEmail(email);
			doctorOnline.setSpeciality(speciality);
			doctorOnline.setRoomId(roomID);
			session.persist(doctorOnline);
		}
		return doctorOnline;
	}
	@Transactional
	public void doctorOffline(String email) {
		Session session= entityManager.unwrap(Session.class);
		DoctorOnline doctorOnline=session.get(DoctorOnline.class,email);
		session.remove(doctorOnline);
	}
}
