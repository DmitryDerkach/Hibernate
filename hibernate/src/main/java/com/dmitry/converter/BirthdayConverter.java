package com.dmitry.converter;

import java.sql.Date;
import java.util.Optional;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.dmitry.entity.Birthday;

//@Converter(autoApply = true)
public class BirthdayConverter implements AttributeConverter<Birthday, Date>{

	@Override
	public Date convertToDatabaseColumn(Birthday attribute) {
		return Optional.ofNullable(attribute)
				.map(Birthday -> attribute.getBirthDate())
				.map(Date::valueOf)
				.orElse(null);
	}

	@Override
	public Birthday convertToEntityAttribute(Date dbData) {
		return Optional.ofNullable(dbData)
				.map(Date::toLocalDate)
				.map(Birthday::new)
				.orElse(null);
	}

}
