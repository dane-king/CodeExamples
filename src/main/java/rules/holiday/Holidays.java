package rules.holiday;

import static org.joda.time.DateTimeConstants.THURSDAY;

import org.joda.time.DateTime;
import org.joda.time.Weeks;
/**
 * @author Dane
 * 
 */
public class Holidays {

	public static boolean isHoliday(DateTime date) {
		boolean isHoliday = false;
		Months month = Months.values()[date.getMonthOfYear() - 1];
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
		}
		return isHoliday;
	}

	private static boolean isThanksgiving(DateTime date) {
		DateTime start=new DateTime(date.getYear(),date.getMonthOfYear(),1,0,0);
		Weeks weekNum=Weeks.weeksBetween(start, date);
		
		if (Weeks.THREE.equals(weekNum) && date.getDayOfWeek() == THURSDAY) {
			return true;
		}
		return false;
	}

	private enum Months {
		JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
	}

}
