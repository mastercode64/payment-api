package com.mastercode.paymentapi.util;

import java.time.LocalDate;

import com.mastercode.paymentapi.exception.InvalidDateFormatException;

public class LocalDateUtils {

	public static LocalDate stringMonthYearToLocalDate(String stringDate) {
		/**
		 * Converts String to LocalDate, input must use format 'MM/YYYY'
		 */

		if (stringDate == null || stringDate.isEmpty())
			throw new InvalidDateFormatException("Date can not be empty");

		if (stringDate.length() != 7 || stringDate.charAt(2) != '/')
			throw new InvalidDateFormatException("Date must be in format 'MM/YYYY'");

		LocalDate date = null;

		try {
			String[] arrayDate = stringDate.split("/");
			String month = arrayDate[0];
			String year = arrayDate[1];
			date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
		} catch (Exception e) {
			throw new InvalidDateFormatException("Date must be in format 'MM/YYYY'");
		}
		return date;
	}

}
