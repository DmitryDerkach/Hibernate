package com.dmitry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import com.dmitry.converter.BirthdayConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstname;
	private String lastname;
	
	@Column(name = "birth_date")
	private Birthday birthDate;
}
