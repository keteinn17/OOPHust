package MyDate;

public class DateTest {
    public static void main(String[] args) {
        // Create a new MyDate object
        MyDate date = new MyDate(22, 4, 2023);

        // Test the setter methods
        date.setDay("23rd");
        date.setMonth("May");
        date.setYear("twenty twenty two");

        // Test the print methods
        date.print(); // Output: 23 May 2022
        date.print("dd/MM/yyyy"); // Output: 23/05/2022
        date.print("yyyy-MM-dd"); // Output: 2022-05-23
        date.print("dd 'of' MMMM, yyyy"); // Output: 23 of May, 2022

        // Test the DateUtils methods
        MyDate[] dates = {
                new MyDate(1, 1, 2022),
                new MyDate(1, 1, 2021),
                new MyDate(1, 1, 2023)
        };
        DateUtils.sortDates(dates);
        for (MyDate d : dates) {
            d.print("dd/MM/yyyy");
        }
        // Output: 01/01/2021
        //         01/01/2022
        //         01/01/2023

        int result = DateUtils.compareDates(new MyDate(1, 1, 2022), new MyDate(1, 1, 2023));
        System.out.println(result); // Output: -1
    }
}
