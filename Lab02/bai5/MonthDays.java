package bai5;

import java.util.Scanner;

public class MonthDays {
    private static boolean checkNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int month = 0;
        int year = 0;
        String input;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the month (1-12): ");
            input=sc.nextLine();
            valid=checkNumber(input);
            if(!valid) {
                System.out.println("Invalid month. Please enter again.");
                continue;
            }
            month=Integer.parseInt(input);
            if (month >= 1 && month <= 12) {
                valid = true;
            } else {
                System.out.println("Invalid month. Please enter again.");
            }
        }

        input="";

        valid = false;
        while (!valid) {
            System.out.print("Enter the year: ");
            input=sc.nextLine();
            valid=checkNumber(input);
            if(!valid) {
                System.out.println("Invalid month. Please enter again.");
                continue;
            }
            year = Integer.parseInt(input);
            if (year >= 1) {
                valid = true;
            } else {
                System.out.println("Invalid year. Please enter again.");
            }
        }

        int days = getDaysInMonth(month, year);

        System.out.println("Number of days in the month: " + days);

        sc.close();
    }

    public static int getDaysInMonth(int month, int year) {
        int days = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (isLeapYear(year)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
        }

        return days;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
