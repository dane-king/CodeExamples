package rules.holiday;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class HolidaysTest {

	private DateTime date;
	private boolean isHoliday;

	@Parameters
	public static Collection<Object[]> generateData() {
		List<Object[]> dataList = new ArrayList<Object[]>();
		dataList.addAll(CHRISTMAS_10YEARS);
		dataList.addAll(NON_HOLIDAYS_10YEARS);
		dataList.addAll(RANDOM_NON_HOLIDAYS);
		dataList.addAll(THANKSGIVING);
		return dataList;

	}

	private static final List<Object[]> CHRISTMAS_10YEARS=Arrays.asList(TEN_CONSECUTIVE_YEARS(2000, 12, 25, Boolean.TRUE));


	private static final List<Object[]> NON_HOLIDAYS_10YEARS = Arrays
			.asList(TEN_CONSECUTIVE_YEARS(2000, 12, 2, Boolean.FALSE));

	private static final List<Object[]> RANDOM_NON_HOLIDAYS = Arrays
			.asList(new Object[][] {
					{ new DateTime(2012, 1, 16, 0, 0), Boolean.FALSE },
					{ new DateTime(2012, 3, 10, 0, 0), Boolean.FALSE },
					{ new DateTime(2012, 11, 15, 0, 0), Boolean.FALSE },
					{new DateTime(2010, 11, 26, 0, 0), Boolean.FALSE }
					});

	private static final List<Object[]> THANKSGIVING = Arrays
			.asList(new Object[][] {
	//TODO: can we add a message like 'Thanksgiving 2012 to the object array that I could then use in test error message
					{new DateTime(2000, 11, 23, 0, 0), Boolean.TRUE },
					{ new DateTime(2001, 11, 22, 0, 0), Boolean.TRUE },
					{ new DateTime(2002, 11, 28, 0, 0), Boolean.TRUE },
					{ new DateTime(2003, 11, 27, 0, 0), Boolean.TRUE },
					{ new DateTime(2004, 11, 25, 0, 0), Boolean.TRUE },
					{ new DateTime(2005, 11, 24, 0, 0), Boolean.TRUE },
					{ new DateTime(2006, 11, 23, 0, 0), Boolean.TRUE },
					{ new DateTime(2007, 11, 22, 0, 0), Boolean.TRUE },
					{ new DateTime(2008, 11, 27, 0, 0), Boolean.TRUE },
					{ new DateTime(2009, 11, 26, 0, 0), Boolean.TRUE },
					{ new DateTime(2010, 11, 25, 0, 0), Boolean.TRUE },
					{ new DateTime(2011, 11, 24, 0, 0), Boolean.TRUE },
					});

	private static Object[][] TEN_CONSECUTIVE_YEARS(int year, int monthOfYear,
			int dayOfMonth, Boolean expected) {
		Object[][] dates = new Object[10][2];
		for (int i = 0; i < dates.length; i++) {
			dates[i][0] = new DateTime(year++, monthOfYear, dayOfMonth, 0, 0);
			dates[i][1] = expected;
		}
		return dates;
	}

	public HolidaysTest(DateTime date, boolean isHolday) {
		super();
		this.date = date;
		this.isHoliday = isHolday;
	}

	@Test
	public void testHolidays() {
		assertEquals(String.format("Testing %1$s expecting  holiday = %2$s but is holiday = %3$s", this.date.toString("MM/dd/yyyy"), this.isHoliday,Holidays.isHoliday(date)), this.isHoliday, Holidays.isHoliday(date));
	}
}
