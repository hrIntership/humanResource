package com.cme.hr.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cme.hr.model.Background;

@Component
public class BackgroundValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Background.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	}

}
