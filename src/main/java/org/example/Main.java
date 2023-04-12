package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.Scanner;

public class Main {
    private static DigitalVideoDisc disc=new DigitalVideoDisc();
    private static final Order order =new Order();
    private static void show(){
        System.out.println("What do you want to do?\n" +
                "1. Add new digital video\n"+
                "2. Remove digital video\n"+
                "3. List\n"+
                "4. Total cost\n"+
                "5. Exit\n"+
                "Input your choice:\n");
    }
    public static void main(String[] args) {
        Scanner scanner;
        String input;
        Configuration configuration =new Configuration();
        configuration.configure();
        ServiceRegistry registry=new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory=configuration.buildSessionFactory(registry);
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        do{
            show();
            scanner=new Scanner(System.in);
            input=scanner.nextLine();
            switch (input){
                case "1": {
                    order.input(disc,scanner,session);
                    disc=new DigitalVideoDisc();
                    break;
                }
                case "2": {
                    order.list(session);
                    order.removeDigitalVideoDisc(session,scanner);
                    break;
                }
                case "3": {
                    order.list(session);
                    break;
                }

                case "4":{
                    System.out.println("Total cost is: " + order.totalCost(session));
                    break;
                }

                default: {
                    System.out.println("Exit!");
                }
            }
        }while(!input.equals("5"));
        scanner.close();
        sessionFactory.close();
    }
}