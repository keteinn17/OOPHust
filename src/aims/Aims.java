package aims;

import aims.media.*;
import aims.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static DigitalVideoDisc disc=new DigitalVideoDisc();
    private static Book book = new Book();
    private static CompactDisc CD = new CompactDisc();
    private static Order order =new Order();
    private static List<Media> media = new ArrayList<>();
    private static void show(){
        System.out.println("""
                Order Management Application: 
                -------------------------------
                1. Create new order
                2. Add item to the order
                3. List
                4. Total cost
                5. Search
                6. Get a lucky item
                7. Delete item
                8. Exit
                Input your choice: 
                """);
    }
    public static void main(String[] args) {
        MemoryDaemon memoryDaemon=new MemoryDaemon();
        Thread thread=new Thread(memoryDaemon);
        thread.setDaemon(true);
        Scanner scanner;
        String input, title, input1;
        do{
            show();
            scanner=new Scanner(System.in);
            input=scanner.nextLine();
            switch (input){
                case "1": {
                    System.out.println("""
                            1. Digital video disc
                            2. Book
                            3. Compact disc
                            Input your choice: 
                            """);
                    scanner=new Scanner(System.in);
                    input1=scanner.nextLine();
                    switch (input1){
                        case "1":{
                            order.input(disc,scanner);
                            break;
                        }
                        case "2":{
                            order.input(book,scanner);
                            break;
                        }
                        case "3":{
                            order.input(CD,scanner);
                            break;
                        }
                        default:
                            System.out.println("Exit");
                            break;
                    }
                }
                case "2":{
                    //order.addDigitalVideoDisc(scanner);
                    break;
                }
                case "3": {
                    order.list();
                    break;
                }
                case "4": {
                    System.out.println("Total cost is: " + order.totalCost());
                    break;
                }

                case "5":{
                    System.out.println("Input title: ");
                    title=scanner.nextLine();
                    System.out.println(order.search(title));
                    break;
                }

                case "6":{
                    order.getALuckyItem();
                    break;
                }

                case "7":{
                    order.list();
                    int req;
                    System.out.println("Input video you want to delete: ");
                    req=scanner.nextInt();
                    order.removeMedia(req);
                    break;
                }

                default: {
                    System.out.println("Exit!");
                }
            }
        }while(!input.equals("8"));
        scanner.close();


    }
}
