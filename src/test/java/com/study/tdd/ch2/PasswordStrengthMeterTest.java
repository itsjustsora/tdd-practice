package com.study.tdd.ch2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordStrengthMeterTest {

	/*
		첫 번째 테스트 : 모든 규칙을 충족하는 경우
		- 가장 쉽거나 가장 예외적인 상황 선택 -> '암호가 모든 조건을 충족하면 암호 강도는 강함이어야 함'
	 */

	@Test
	void meetsAllCriteria_Then_Strong() {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();

		PasswordStrength result = meter.meter("ab12!@AB");
		assertEquals(PasswordStrength.STRONG, result);

		PasswordStrength result2 = meter.meter("ab1c!Add");
		assertEquals(PasswordStrength.STRONG, result2);
	}

	/*
		두 번째 테스트 : 길이만 8글자 미만이고 나머지 조건은 충족하는 경우
	 */

	@Test
	void meetsOtherCriteria_except_form_Length_Then_Normal() {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();

		PasswordStrength result = meter.meter("ab12!@A");
		assertEquals(PasswordStrength.NORMAL, result);

		PasswordStrength result2 = meter.meter("Ab12!c");
		assertEquals(PasswordStrength.NORMAL, result2);
	}

	/*
		세 번째 테스트 : 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
	 */

	@Test
	void meetsOtherCriteria_except_form_number_Then_Normal() {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();

		PasswordStrength result = meter.meter("ab!@ABqwer");
		assertEquals(PasswordStrength.NORMAL, result);
	}
}
