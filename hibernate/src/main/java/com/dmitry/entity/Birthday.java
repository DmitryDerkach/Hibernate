package com.dmitry.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.hibernate.type.LocalDateTimeType;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

public class Birthday {

	private LocalDate birthDate;
	
	public Birthday() {
		// TODO Auto-generated constructor stub
	}
	
	public Birthday(LocalDate birthDate) {
		// TODO Auto-generated constructor stub
		this.birthDate = birthDate;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public long getAge() {
		return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
	}
	
}
