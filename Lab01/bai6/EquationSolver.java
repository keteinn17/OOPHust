package bai6;

import java.util.Scanner;

public class EquationSolver {

    private static void show(){
        System.out.println("Choose the type of equation to solve: ");
        System.out.println("1. Linear equation with one variable");
        System.out.println("2. Linear equation with two variables");
        System.out.println("3. Quadratic equation with one variable");
    }
    public static void main(String[] args) {
        double a,b,c,d;
        String num1, num2;
        Scanner scanner;
        String choice;
        double[] params = new double[6];

        String[] paramNames = {"a", "b", "c", "d", "e", "f"};
        do{
            show();
            System.out.println("Input your choice: ");
            scanner = new Scanner(System.in);
            choice = scanner.nextLine();
            if(choice.equals("exit")) continue;
            switch (choice) {
                case "1":{
                    while (true) {
                        System.out.print("Enter the value of a: ");
                        if (scanner.hasNextDouble()) {
                            a = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // discard invalid input
                        }
                    }

                    // Loop until valid input is entered for b
                    while (true) {
                        System.out.print("Enter the value of b: ");
                        if (scanner.hasNextDouble()) {
                            b = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // discard invalid input
                        }
                    }

                    if (a == 0) {
                        if (b == 0) {
                            System.out.println("The equation has infinitely many solutions.");
                        } else {
                            System.out.println("The equation has no solution.");
                        }
                    } else {
                        double x = -b / a;
                        System.out.println("The solution is x = " + x);
                    }
                    break;
                }
                case "2":
                    for (int i = 0; i < 6; i++) {
                        while (true) {
                            System.out.print("Enter the value of " + paramNames[i] + ": ");
                            if (scanner.hasNextDouble()) {
                                params[i] = scanner.nextDouble();
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next(); // discard invalid input
                            }
                        }
                    }

                    a = params[0];
                    b = params[1];
                    c = params[2];
                    d = params[3];
                    double e = params[4];
                    double f = params[5];

                    if (a * d - b * c == 0) {
                        System.out.println("The equation has no solution.");
                    } else {
                        double x = (e * d - b * f) / (a * d - b * c);
                        double y = (a * f - e * c) / (a * d - b * c);
                        System.out.println("The solution is x = " + x + ", y = " + y);
                    }
                    break;
                case "3":
                    while (true) {
                        System.out.print("Enter the value of a: ");
                        if (scanner.hasNextDouble()) {
                            a = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // discard invalid input
                        }
                    }

                    // Loop until valid input is entered for b
                    while (true) {
                        System.out.print("Enter the value of b: ");
                        if (scanner.hasNextDouble()) {
                            b = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // discard invalid input
                        }
                    }

                    // Loop until valid input is entered for c
                    while (true) {
                        System.out.print("Enter the value of c: ");
                        if (scanner.hasNextDouble()) {
                            c = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // discard invalid input
                        }
                    }

                    double discriminant = b * b - 4 * a * c;

                    if (a == 0) {
                        if(b!=0){
                            System.out.println("The equation has one root: "+ (-c/b));
                        }else{
                            if(c==0) System.out.println("The equation has infinity root.");
                            else System.out.println("The equation has no root.");
                        }
                        //System.out.println("The equation is not a quadratic equation.");
                    } else if (discriminant < 0) {
                        System.out.println("The equation has no real roots.");
                    } else if (discriminant == 0) {
                        double root = -b / (2 * a);
                        System.out.println("The equation has one root: " + root);
                    } else {
                        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                        System.out.println("The equation has two roots: " + root1 + " and " + root2);
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }while(!choice.equals("exit"));
        scanner.close();
    }
}
