package com.amigoscode.testing.utils;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PhoneNumberValidatorTest {
	
	private PhoneNumberValidator underTest;
	
	@BeforeEach
	void setUp() {
		underTest = new PhoneNumberValidator();
	}
	
	
	@ParameterizedTest
	@CsvSource("+17138320697, TRUE")
	void validatePhoneNumber(String phoneNumber, String expected) {
		
		// When
		boolean isValid = underTest.test(phoneNumber);
		
		// Then
		assertThat(isValid).isEqualTo(Boolean.valueOf(expected));
	}
	
	@Test
	@DisplayName("Bigger than 12 should fail ")
	void validatePhoneNumberToBeIncorrectWithIncorrectLength() {
		// Given
		String phoneNumber = "+17138320697000000";
		
		// When
		boolean isValid = underTest.test(phoneNumber);
		
		// Then
		assertThat(isValid).isFalse();
	}
}
