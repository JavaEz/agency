package exampledao.someanothermethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeConverter {

	LocalDate date = LocalDate.now();

	public static LocalDate stringToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(date, formatter);
	}

	public static java.sql.Date toSqlDate(String date) {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.parse(date, format));
		return sqlDate;

	}
	public static long daysDifference(String start, String end) {
		LocalDate parsedStart =  DateTimeConverter.stringToDate(start);
		LocalDate parsedend =  DateTimeConverter.stringToDate(end);
		long daysBetween = ChronoUnit.DAYS.between(parsedStart, parsedend);
		return daysBetween;
	}
}
