package rules.holiday;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;



@RunWith(Parameterized.class)
public class HolidaysTest {

	private LocalDate date;
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
					{ LocalDate.of(2012, 1, 16), Boolean.FALSE },
					{ LocalDate.of(2012, 3, 10), Boolean.FALSE },
					{ LocalDate.of(2012, 11, 15), Boolean.FALSE },
					{LocalDate.of(2010, 11, 26), Boolean.FALSE }
					});

	private static final List<Object[]> THANKSGIVING = Arrays
			.asList(new Object[][] {
	//TODO: can we add a message like 'Thanksgiving 2012 to the object array that I could then use in test error message
					{LocalDate.of(2000, 11, 23), Boolean.TRUE },
					{ LocalDate.of(2001, 11, 22), Boolean.TRUE },
					{ LocalDate.of(2002, 11, 28), Boolean.TRUE },
					{ LocalDate.of(2003, 11, 27), Boolean.TRUE },
					{ LocalDate.of(2004, 11, 25), Boolean.TRUE },
					{ LocalDate.of(2005, 11, 24), Boolean.TRUE },
					{ LocalDate.of(2006, 11, 23), Boolean.TRUE },
					{ LocalDate.of(2007, 11, 22), Boolean.TRUE },
					{ LocalDate.of(2008, 11, 27), Boolean.TRUE },
					{ LocalDate.of(2009, 11, 26), Boolean.TRUE },
					{ LocalDate.of(2010, 11, 25), Boolean.TRUE },
					{ LocalDate.of(2011, 11, 24), Boolean.TRUE },
					});

	private static Object[][] TEN_CONSECUTIVE_YEARS(int year, int monthOfYear,
			int dayOfMonth, Boolean expected) {
		Object[][] dates = new Object[10][2];
		for (int i = 0; i < dates.length; i++) {
			dates[i][0] = LocalDate.of(year++, monthOfYear, dayOfMonth);
			dates[i][1] = expected;
		}
		return dates;
	}

	public HolidaysTest(LocalDate date, boolean isHoliday) {
		super();
		this.date = date;
		this.isHoliday = isHoliday;
	}

	@Test
	public void testHolidays() {
		assertEquals(String.format("Testing %1$s expecting  holiday = %2$s but is holiday = %3$s", this.date.toString(), this.isHoliday,Holidays.isHoliday(date)), this.isHoliday, Holidays.isHoliday(date));
	}
}
