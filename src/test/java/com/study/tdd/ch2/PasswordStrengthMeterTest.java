package com.study.tdd.ch2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordStrengthMeterTest {

	private PasswordStrengthMeter meter = new PasswordStrengthMeter();

	private void assertStrength(String password, PasswordStrength expStr) {
		PasswordStrength result = meter.meter(password);
		assertEquals(expStr, result);
	}

	/*
		첫 번째 테스트 : 모든 규칙을 충족하는 경우
		- 가장 쉽거나 가장 예외적인 상황 선택 -> '암호가 모든 조건을 충족하면 암호 강도는 강함이어야 함'
	 */
	@Test
	void meetsAllCriteria_Then_Strong() {
		assertStrength("ab12!@AB", PasswordStrength.STRONG);
		assertStrength("ab1c!Add", PasswordStrength.STRONG);
	}

	// 두 번째 테스트 : 길이만 8글자 미만이고 나머지 조건은 충족하는 경우
	@Test
	void meetsOtherCriteria_except_form_Length_Then_Normal() {
		assertStrength("ab12!@A", PasswordStrength.NORMAL);
		assertStrength("Ab12!c", PasswordStrength.NORMAL);
	}

	// 세 번째 테스트 : 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
	@Test
	void meetsOtherCriteria_except_form_number_Then_Normal() {
		assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
	}

	// 네 번째 테스트 : 값이 없는 경우
	@Test
	void nullInput_Then_Invalid() {
		assertStrength(null, PasswordStrength.INVALID);
		assertStrength("", PasswordStrength.INVALID);
	}

	// 다섯 번째 테스트 : 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
	@Test
	void meetsOtherCriteria_except_form_Uppercase_Then_Normal() {
		assertStrength("ab12!@df", PasswordStrength.NORMAL);
	}

	// 여섯 번째 테스트: 길이가 8글자 이상인 조건만 충족하는 경우
	@Test
	void meetsOnlyLengthCriteria_Then_Weak() {
		assertStrength("abdefghi", PasswordStrength.WEAK);
	}

	// 일곱 번째 테스트: 숫자 포함 조건만 충족하는 경우
	@Test
	void meetsOnlyNumCriteria_Then_Weak() {
		assertStrength("12345", PasswordStrength.WEAK);
	}

	// 여덟 번째 테스트: 대문자 포함 조건만 충족하는 경우
	@Test
	void meetsOnlyUpperCriteria_Then_Weak() {
		assertStrength("ABCDE", PasswordStrength.WEAK);
	}
}
