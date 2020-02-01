package rules.holiday;


import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Dane
 * 
 */
public class Holidays {

	public static boolean isHoliday(LocalDate date) {
		boolean isHoliday = false;
		Months month = Months.values()[date.getMonth().getValue()- 1];
		switch (month) {
		// Months
		case NOV:
			isHoliday = isThanksgiving(date);
			break;
		case DEC:
			switch (date.getDayOfMonth()) {
			case 25:
				isHoliday = true;
				break;
			}
			break;
		default:
			isHoliday=false;
			break;
		}
		return isHoliday;
	}

	private static boolean isThanksgiving(LocalDate date) {

		LocalDate thanksGiving = Year.of(date.getYear()).atMonth(Month.NOVEMBER).atDay(1)
				.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.THURSDAY));
		return thanksGiving.equals(date);
	}

	private enum Months {
		JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
	}

}
