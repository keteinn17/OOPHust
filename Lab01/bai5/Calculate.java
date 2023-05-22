package bai5;

import java.util.Scanner;

public class Calculate {
    boolean checkNumber(String number){
        try{
            Double.parseDouble(number);
            return true;
        }catch (NumberFormatException numberFormatException){
            return false;
        }
    }

    private static double sum(double a, double b){
        return a+b;
    }

    private static double different(double a, double b){
        return a-b;
    }

    private static double product(double a, double b){
        return a*b;
    }

    private static double quotient(double a, double b){
        try{
            return a/b;
        }catch (NumberFormatException e){
            throw new NumberFormatException("Invalid divisor");
        }
    }

    public static void main(String[] args) {
        String num1, num2;
        Calculate calculate=new Calculate();
        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("Num 1: ");
            num1=scanner.nextLine();
            System.out.println("Num 2: ");
            num2=scanner.nextLine();
        }while ((!calculate.checkNumber(num1)&&!calculate.checkNumber(num2)));
            double number1=Double.parseDouble(num1);
            double number2=Double.parseDouble(num2);
            System.out.println("Sum: "+ sum(number1,number2));
            System.out.println("Different: "+ different(number1,number2));
            System.out.println("Product: "+ product(number1,number2));
            System.out.println("Quotient: "+ quotient(number1,number2));
    }
}
