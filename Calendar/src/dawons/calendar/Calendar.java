package dawons.calendar;

import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		}else {
			return MAX_DAYS[month];
		}
		
	}
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void printCalendar(int year, int month) {
		System.out.printf("<<%4d³â%3d¿ù>>\n",year,month);
		System.out.println("  SU MO TU WE TH FR SA");
		System.out.println("-----------------------");
		
		int maxDay = getMaxDaysOfMonth(year,month);

		for(int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if(i % 7 == 0)
				System.out.println();
		}

		System.out.println();
	}

}
