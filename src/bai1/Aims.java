package bai1;

import java.util.Scanner;

public class Aims {
    private static DigitalVideoDisc disc=new DigitalVideoDisc();
    private static Order order =new Order();
    private static void show(){
        System.out.println("""
                What do you want to do?
                1. Add new digital video
                2. Remove digital video
                3. List
                4. Total cost
                5. Exit
                Input your choice: 
                """);
    }
    public static void main(String[] args) {
        Scanner scanner;
        String input;
        do{
            show();
            scanner=new Scanner(System.in);
            input=scanner.nextLine();
            switch (input){
                case "1": {
                    order.input(disc,scanner);
                    order.addDigitalVideoDisc(disc);
                    disc=new DigitalVideoDisc();
                    break;
                }
                case "2": {
                    order.list();
                    int req;
                    System.out.println("Input video you want to delete: ");
                    req=scanner.nextInt();
                    order.removeDigitalVideoDisc(req);
                    break;
                }
                case "3": {
                    order.list();
                    break;
                }

                case "4":{
                    System.out.println("Total cost is: " + order.totalCost());
                    break;
                }

                default: {
                    System.out.println("Exit!");
                }
            }
        }while(!input.equals("5"));
    }
}
