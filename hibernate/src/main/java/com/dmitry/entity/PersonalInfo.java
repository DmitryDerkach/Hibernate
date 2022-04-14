package com.dmitry.entity;

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
public class PersonalInfo {
	private String firstname;
	private String lastname;
	
	@Column(name = "birth_date")
	private Birthday birthDate;
}
