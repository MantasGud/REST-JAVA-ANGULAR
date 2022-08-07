package com.seb.restapi.model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seb.restapi.validations.EmailValidation;
import com.seb.restapi.validations.TelNumberValidation;

public class Customer {

	 private Integer id;
	 
	 @Valid
	 @NotNull
	 private String name;
	 
	 @Valid
	 @NotNull
	 private String surname;
	 
	 @JsonFormat(pattern = "yyyy/MM/dd")
	 private Date birthDate;
	 
	 @Valid
	 @NotNull
	 @TelNumberValidation()
	 private Long telNumber;
	 
	 @Valid
	 @NotNull
	 //@Email
	 @EmailValidation()
	 private String email;
	 
	 public Customer() {

	 }

	 public Customer(Integer id, String name, String surname, Date birthDate, Long telNumber, String email) {
		 super();
	     this.id = id;
	     this.name = name;
	     this.surname = surname;
	     this.birthDate = birthDate;
	     this.telNumber = telNumber;
	     this.email = email;
	 }
	 
	 @Override
	 public String toString() {
		 final SimpleDateFormat  dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
		 return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"surname\":\"" + surname + "\",\"birthDate\":\"" + dateFormatter.format(birthDate) + "\",\"telNumber\":\"" + 
				 	telNumber + "\",\"email\":\"" + email + "\"" + "}";
	 }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Long getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(Long telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
}
