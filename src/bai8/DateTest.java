package bai8;

import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        // test no-arg constructor
        MyDate date1 = new MyDate();
        date1.print();

        // test constructor with day, month, year
        MyDate date2 = new MyDate(18, 2, 2019);
        date2.print();

        // test constructor with date string
        MyDate date3 = new MyDate("February 18 2019");
        date3.print();

        // test setters and getters
        date1.setMonth(12);
        date1.setDay(31);
        date1.setYear(2022);
        System.out.println(date1.getDay());
        System.out.println(date1.getMonth());
        System.out.println(date1.getYear());

        // test accept() and print() methods
        date1.accept(scanner);
        date1.print();
    }
}
