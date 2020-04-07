package mr.esp.springdemo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.validation.constraints.PastOrPresent;

public class StudentsDto {
	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@PastOrPresent
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dateOfBirth;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


}
