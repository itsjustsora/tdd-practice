package com.study.tdd.ch3;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpiryDateCalculatorTest {
	@Test
	void 만원_납부하면_한달_뒤가_만료일이_됨() {

		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2023,3,8))
			.payAmount(10_000)
			.build(),
			LocalDate.of(2023, 4, 8));
		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2023,5,8))
			.payAmount(10_000)
			.build(),
			LocalDate.of(2023, 6, 8));

	}

	@Test
	void 납부일과_한달_뒤_일자가_같지_않음() {
		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2023,1,31))
			.payAmount(10_000)
			.build(),
			LocalDate.of(2023, 2, 28));
		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2023,5,31))
			.payAmount(10_000)
			.build(),
			LocalDate.of(2023, 6, 30));
	}

	@Test
	void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
		PayData payData = PayData.builder()
			.firstBuillingDate(LocalDate.of(2023,1,31))
			.billingDate(LocalDate.of(2023,2,28))
			.payAmount(10_000)
			.build();

		assertExpiryDate(payData, LocalDate.of(2023,3,31));
	}

	@Test
	void 이만원_이상_납부하면_비례해서_만료일_계산() {
		assertExpiryDate(
			PayData.builder()
				.billingDate(LocalDate.of(2023,3,1))
				.payAmount(20_000)
				.build(),
			LocalDate.of(2023,5,1)
		);
		assertExpiryDate(
			PayData.builder()
				.billingDate(LocalDate.of(2023,3,1))
				.payAmount(30_000)
				.build(),
			LocalDate.of(2023,6,1)
		);
	}

	@Test
	void 첫_납부일과_만료일_일자가_다를때_이만원_납부() {
		PayData payData = PayData.builder()
			.firstBuillingDate(LocalDate.of(2023,1,31))
			.billingDate(LocalDate.of(2023,2,28))
			.payAmount(20_000)
			.build();

		assertExpiryDate(payData, LocalDate.of(2023,4,30));
	}

	@Test
	void 십만원을_납부하면_1년_제공() {
		PayData payData = PayData.builder()
			.billingDate(LocalDate.of(2023,1,28))
			.payAmount(100_000)
			.build();

		assertExpiryDate(payData, LocalDate.of(2024,1,28));
	}

	private void assertExpiryDate(
		PayData data, LocalDate expectedExpiryDate) {
		ExpiryDateCalculator cal = new ExpiryDateCalculator();
		LocalDate realExpiryDate = cal.calculateExpiryDate(data);

		Assertions.assertEquals(expectedExpiryDate, realExpiryDate);
	}
}
