package com.incapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incapp.models.Doctor;
import com.incapp.models.DoctorAvail;
import com.incapp.models.DoctorDetails;
import com.incapp.models.DoctorNotAvail;
import com.incapp.models.DoctorOnline;
import com.incapp.repo.DoctorRepo;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepo doctorRepo;
	
	public List<Doctor> getDoctors() {
		return doctorRepo.getDoctors();
	}

	public List<Doctor> getDoctorsBySpeciality(String speciality) {
		return doctorRepo.getDoctorsBySpeciality(speciality);
	}
	public List<Doctor> getDoctors(String state, String city, String speciality) {
		return doctorRepo.getDoctors(state,city,speciality);
	}
	public boolean register(Doctor doctor) {
		return doctorRepo.register(doctor);
	}

	public Doctor getDoctor(String email) {
		return doctorRepo.getDoctor(email);
	}

	public Doctor updateDocAvail(String email, DoctorAvail doctorAvail) {
		return doctorRepo.updateDocAvail(email,doctorAvail);
	}

	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepo.updateDoctor(doctor);
	}

	public boolean updateDoctorPhoto(String email, byte[] photo) {
		return doctorRepo.updateDoctorPhoto(email,photo);
	}

	public boolean addDocNotAvail(DoctorNotAvail doctorNotAvail) {
		return doctorRepo.addDocNotAvail(doctorNotAvail);
	}

	public byte[] getDoctorPhoto(String email) {
		return doctorRepo.getDoctorPhoto(email);
	}

	public boolean updatePassword(String email, String newPassword) {
		return doctorRepo.updatePassword(email,newPassword);
	}

	public List<DoctorNotAvail> getDocNotAvail(String email) {
		return doctorRepo.getDocNotAvail(email);
	}

	public boolean cancelDocNotAvail(int id) {
		return doctorRepo.cancelDocNotAvail(id);
	}

	public DoctorOnline getDoctorOnline(String email) {
		return doctorRepo.getDoctorOnline(email);
	}

	public DoctorOnline doctorOnline(String email, String speciality) {
		return doctorRepo.doctorOnline(email,speciality);
	}

	public void doctorOffline(String email) {
		doctorRepo.doctorOffline(email);
	}

	
}
