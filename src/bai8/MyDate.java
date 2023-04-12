package bai8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        LocalDate currentDate = LocalDate.now();
        this.day = currentDate.getDayOfMonth();
        this.month = currentDate.getMonthValue();
        this.year = currentDate.getYear();
    }

    public MyDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date!");
        }
    }

    public MyDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy");
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            this.day = date.getDayOfMonth();
            this.month = date.getMonthValue();
            this.year = date.getYear();
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date string!");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (isValidDate(day, this.month, this.year)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day!");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (isValidDate(this.day, month, this.year)) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month!");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (isValidDate(this.day, this.month, year)) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year!");
        }
    }

    public void accept(Scanner scanner) {
        System.out.print("Please enter a date (e.g. February 18th 2019): ");
        String dateStr = scanner.nextLine();
        MyDate newDate = new MyDate(dateStr);
        this.day = newDate.getDay();
        this.month = newDate.getMonth();
        this.year = newDate.getYear();
    }

    public void print() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d uuuu");
        LocalDate date = LocalDate.of(this.year, this.month, this.day);
        System.out.println(date.format(formatter));
    }

    private static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || year > 9999) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        int maxDay=31;
        if(month == 1 || month == 3 || month == 5 || month == 7 || month==8 || month ==10 || month ==12){
            maxDay=31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                maxDay = 29;
            } else {
                maxDay = 28;
            }
        }
        return day >= 1 && day <= maxDay;
    }
}
