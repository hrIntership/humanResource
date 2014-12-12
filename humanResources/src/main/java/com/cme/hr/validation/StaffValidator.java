package com.cme.hr.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cme.hr.model.Staff;

@Component
public class StaffValidator implements Validator {
	
	private final static String ID_NUMBER = "salary";

	@Override
	public boolean supports(Class<?> clazz) {
		return Staff.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Staff staff = (Staff) target;
		
		Integer salary = staff.getIdPerson();
		
		ValidationUtils.rejectIfEmpty(errors, "salary", "staff.salary.empty");


		if (salary != null && salary < 1)
			errors.rejectValue(ID_NUMBER, "staff.salary.lessThenOne");
	}

}
