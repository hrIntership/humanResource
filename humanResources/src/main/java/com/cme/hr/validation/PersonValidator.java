package com.cme.hr.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cme.hr.model.Person;

@Component
public class PersonValidator implements Validator {
	
	private final static String ID_NUMBER = "idNumber";

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		
		Integer idNumber = person.getIdNumber();
		
		ValidationUtils.rejectIfEmpty(errors, "firstname", "person.firstname.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "person.lastname.empty");
		ValidationUtils.rejectIfEmpty(errors, "idType", "person.idType.empty");
		ValidationUtils.rejectIfEmpty(errors, ID_NUMBER, "person.idNumber.empty");
		ValidationUtils.rejectIfEmpty(errors, "cuil", "person.cuil.empty");
		ValidationUtils.rejectIfEmpty(errors, "gender", "person.gender.empty");
		ValidationUtils.rejectIfEmpty(errors, "maritalStatus", "person.maritalStatus.empty");
		ValidationUtils.rejectIfEmpty(errors, "nationality", "person.nationality.empty");
		ValidationUtils.rejectIfEmpty(errors, "birthdate", "person.birthdate.empty");
		ValidationUtils.rejectIfEmpty(errors, "address1", "person.address1.empty");
		ValidationUtils.rejectIfEmpty(errors, "city", "person.city.empty");
		ValidationUtils.rejectIfEmpty(errors, "province", "person.province.empty");
		ValidationUtils.rejectIfEmpty(errors, "zipCode", "person.zipCode.empty");
		ValidationUtils.rejectIfEmpty(errors, "country", "person.country.empty");
		ValidationUtils.rejectIfEmpty(errors, "phone", "person.phone.empty");
		ValidationUtils.rejectIfEmpty(errors, "movile", "person.movile.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "person.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "state", "person.state.empty");

		if (idNumber != null && idNumber < 1)
			errors.rejectValue(ID_NUMBER, "person.idNumber.lessThenOne");
	}

}
