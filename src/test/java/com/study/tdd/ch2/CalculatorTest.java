package com.study.tdd.ch2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	/*
		이 테스트 코드를 짜기 위한 고민의 흔적
		1. 메서드 이름은 plus or sum?
		2. 덧셈 기능을 제공하는 메서드는 파라미터가 몇 개여야 할까? 파라미터의 타입? 반환 값?
		3. 메서드를 정적 메서드로 구현할까 인스턴스 메서드로 구현할까?
		4. 메서드를 제공할 클래스 이름은 뭐가 좋을까?
	 */
	@Test
	void plus() {
		int result = Calculator.plus(1, 2);
		/*
			assertEquals() : 기대한 값과 실제 값이 동일한지 비교
			동일하지 않다면 AssertionFailedError 발생
		 */
		assertEquals(3, result);
		assertEquals(5, Calculator.plus(1, 4));
	}
}
