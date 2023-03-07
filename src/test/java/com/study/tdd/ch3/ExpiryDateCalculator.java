package com.study.tdd.ch3;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
	public LocalDate calculateExpiryDate(PayData data) {
		int addedMonths = data.getPayAmount() == 100_000 ? 12 : data.getPayAmount() / 10_000;
		if (data.getFirstBillingDate() != null) {
			return expiryDateUsingFirstBillingDate(data, addedMonths);
		} else {
			return data.getBillingDate().plusMonths(addedMonths);
		}
	}

	private static LocalDate expiryDateUsingFirstBillingDate(PayData data, int addedMonths) {
		LocalDate candidateExp = data.getBillingDate().plusMonths(addedMonths);

		if (isSameDayOfMonth(data.getFirstBillingDate(), candidateExp)) {
			final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
			final int dayOfFirstBilling = data.getFirstBillingDate().getDayOfMonth();
			if (dayLenOfCandiMon < dayOfFirstBilling) {
				return candidateExp.withDayOfMonth(dayLenOfCandiMon);
			}
			return candidateExp.withDayOfMonth(dayOfFirstBilling);
		} else {
			return candidateExp;
		}
	}

	private static boolean isSameDayOfMonth(LocalDate firstBillingDate, LocalDate candidateExp) {
		return firstBillingDate.getDayOfMonth() != candidateExp.getDayOfMonth();
	}

	private static int lastDayOfMonth(LocalDate date) {
		return YearMonth.from(date).lengthOfMonth();
	}
}
