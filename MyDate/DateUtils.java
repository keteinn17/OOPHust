package MyDate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DateUtils {
    public static int compareDates(MyDate date1, MyDate date2) {
        return new Date(date1.getYear() - 1900, date1.getMonth() - 1, date1.getDay())
                .compareTo(new Date(date2.getYear() - 1900, date2.getMonth() - 1, date2.getDay()));
    }

    public static void sortDates(MyDate[] dates) {
        Arrays.sort(dates, Comparator.comparing(date -> new Date(date.getYear() - 1900, date.getMonth() - 1, date.getDay())));
    }
}
