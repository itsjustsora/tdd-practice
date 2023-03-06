package com.study.tdd.ch2;

public class Calculator {

	/*
		TDD에 적응하기 위한 단계
		1. return 0 (테스트 실패 유도)
		2. return 3 (원하는 값 하드코딩)

		기능이 완성되기 전에는 src/test/java 디렉토리에서 작업한다.
		해당 소스 폴더는 배포 대상이 아니기 때문에 실수를 방지할 수 있다.
	 */

	public static int plus(int operand1, int operand2) {
		return operand1 + operand2;
	}
}
