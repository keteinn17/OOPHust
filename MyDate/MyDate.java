package MyDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setDay(String day) {
        this.day = convertStringToInt(day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setMonth(String month) {
        this.month = convertMonthStringToInt(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setYear(String year) {
        this.year = convertStringToInt(year);
    }

    private static int convertMonthStringToInt(String month) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(new SimpleDateFormat("MM").format(date));
    }

    private static int convertStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            Date date = null;
            try {
                date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(value);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            return Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
        }
    }

    public void print() {
        System.out.println(getFormattedDate("dd MMMM yyyy"));
    }

    public void print(String format) {
        System.out.println(getFormattedDate(format));
    }

    private String getFormattedDate(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
        return formatter.format(new Date(year - 1900, month - 1, day));
    }
}


