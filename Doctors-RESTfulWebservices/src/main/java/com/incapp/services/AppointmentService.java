package com.incapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incapp.models.Appointments;
import com.incapp.repo.AppointmentRepo;

import jakarta.transaction.Transactional;

@Service
public class AppointmentService {
	@Autowired
	AppointmentRepo appointmentRepo;

	public List<Appointments> getByUserEmail(String userEmail) {
		return appointmentRepo.getByUserEmail(userEmail);
	}

	public List<Appointments> getByDoctorEmail(String doctorEmail) {
		return appointmentRepo.getByDoctorEmail(doctorEmail);
	}
	
	public boolean delete(int id) {
		return appointmentRepo.delete(id);
	}

	public String addAppointment(Appointments appointment) {
		return appointmentRepo.addAppointment(appointment);
	}

	public Appointments updateStatus(int id, String status) {
		return appointmentRepo.updateStatus(id,status);
	}
	
}
