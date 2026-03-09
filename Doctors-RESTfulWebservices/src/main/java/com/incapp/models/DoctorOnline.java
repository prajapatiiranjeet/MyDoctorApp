package com.incapp.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 */
@Entity
//----lombok
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DoctorOnline {
	@Id
	private String docEmail;
	private String userEmail;
	@Column(nullable = false)
	private String speciality;
	private String roomId;
	
}
