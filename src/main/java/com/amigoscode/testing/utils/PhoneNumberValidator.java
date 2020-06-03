package com.amigoscode.testing.utils;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String>{

	@Override
	public boolean test(String phoneNumber) {
		
		if(phoneNumber.startsWith("+1") && phoneNumber.length() == 12) {
			return true;
		}
		
		return false;
	}

	

}
