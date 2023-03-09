package com.study.tdd.ch7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRegisterTest {
	private UserRegister userRegister;
	private StubWeakPasswordChecker stubPasswordChecker =
		new StubWeakPasswordChecker();

	@BeforeEach
	void setUp() {
		userRegister = new UserRegister(stubPasswordChecker);
	}

	@DisplayName("약한 암호면 가입 실패")
	@Test
	void weakPassword() {
		stubPasswordChecker.setWeak(true);

		assertThrows(WeakPasswordException.class, () -> {
			userRegister.register("id", "pw", "email");
		});
	}
}
