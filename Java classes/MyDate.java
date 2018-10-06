import java.io.Serializable;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class MyDate implements Serializable {

	private int minute;
	private int hour;
	private int day;
	private int month;
	private int year;

	public MyDate() {

		GregorianCalendar currentDate = new GregorianCalendar();

		minute = currentDate.get(GregorianCalendar.MINUTE);
		hour = currentDate.get(GregorianCalendar.HOUR);
		day = currentDate.get(GregorianCalendar.DATE);

		// Add a value of plus one to add to the initial value of 0.

		month = currentDate.get(GregorianCalendar.MONTH) + 1;
		year = currentDate.get(GregorianCalendar.YEAR);
	}

	public MyDate(int minute, int hour, int day, int month, int year) {

		this.minute = minute;
		this.hour = hour;
		this.day = day;
		this.month = month;
		this.year = year;

	}

	public int getMinute() {
		return minute;
	}

	public int getHour() {
		return hour;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {

		this.month = month;
	}

	public void setYear(int year) {

		this.year = year;

	}

	public static MyDate currentDate() {
		return new MyDate();
	}

	public void setDate(int mimnute, int hour, int day, int month, int year) {

		// SafeGuard for invalid inputs.

		this.day = day;
		this.month = month;
		this.year = year;

		if (hour < 0) {
			hour = hour * -1;
		}

		if (hour > 23) {
			hour = 23;
		}

		if (minute < 0) {
			minute = minute * -1;
		}

		if (minute > 59) {
			minute = 59;
		}

		if (day > numberOfDaysInMonth(month)) {

			day = numberOfDaysInMonth(month);
		}

		if (month < 1) {
			month = 1;
		}
		if (year < 0) {
			year = year * -1;

		}

	}

	public static int monthNameToString(String month) {

		switch (month.toLowerCase()) {

		case "january":
			return 1;
		case "february":
			return 2;
		case "march":
			return 3;
		case "april":
			return 4;
		case "may":
			return 5;
		case "june":
			return 6;
		case "july":
			return 7;
		case "august":
			return 8;
		case "september":
			return 9;
		case "october":
			return 10;
		case "november":
			return 11;
		case "december":
			return 12;
		default:
			return -1;
		}
	}

	public void setDateMonth(int hour, int minute, int day, String month, int year) {

		setDate(hour, minute, day, monthNameToString(month), year);

	}

	public boolean isOtherDate(MyDate other) {

		if (year < other.getYear())
			return true;
		else if (year == other.getYear())
			if (month < other.getMonth())
				return true;
			else if (month == other.getMonth())
				if (day < other.getDay())
					return true;
		if (hour < other.getDay())
			return true;
		else if (hour == other.getHour())
			if (minute < other.getMinute())
				return true;

		return false;
	}

	public boolean isLeapYear() {
		if (year % 400 == 0) {
			return true;
		} else if (year % 100 != 0 && year % 4 == 0)
			return true;

		return false;
	}

	public int numberOfDaysInMonth(int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		else if (month != 2)
			return 30;
		else if (isLeapYear())
			return 29;
		else
			return 28;
	}

	public MyDate copy() {

		return new MyDate(minute, hour, day, month, year);

	}

	public int daysBetween(MyDate other) {
		MyDate baseDate;
		MyDate focusDate;
		if (isOtherDate(other)) {
			baseDate = this.copy();
			focusDate = other.copy();
		} else {
			baseDate = other.copy();
			focusDate = this.copy();
		}

		int i = 0;

		while (!baseDate.equals(focusDate)) {
			baseDate.stepForwardOneDay();
			i++;
		}

		return i;
	}

	public int yearsBetween(MyDate other) {
		if (!isOtherDate(other)) {
			return other.yearsBetween(this);
		}

		int dayDifference = day - other.getDay();
		int monthDifference = month - other.getMonth();
		int j = 0;

		if (monthDifference > 0)
			j++;
		else if (monthDifference == 0)
			if (dayDifference > 0)
				j++;

		return other.getYear() - year - j;
	}

	public void stepForwardOneDay() {
		day++;
		if (day > numberOfDaysInMonth(month)) {
			day = 1;
			month++;
		}
		if (month > 12) {
			month = 1;
			year++;
		}
	}

	public void stepForward(int days) {
		for (int i = 0; i < days; i++)
			stepForwardOneDay();
	}

	public boolean equals(Object input) {

		if (!(input instanceof MyDate))
			return false;
		else {
			MyDate obj = (MyDate) input;
			if (day == obj.day && month == obj.month && year == obj.year)
				return true;
			else
				return false;
		}
	}

	public String toString() {

		if (month < 10) {
			String myDate = day + "/0" + month + "/" + year;
			return myDate;
		} else {

			String myDate = day + "/" + month + "/" + year;
			return myDate;
		}
	}
}
