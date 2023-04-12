package org.example;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;


public class Order {
    public static final int MAX_NUMBERS_ORDERED=10;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private DVDRepository dvdRepository;
    public Order(){};


    public Order(DVDRepository dvdRepository){
        this.dvdRepository=dvdRepository;
    }
    private int qtyOrdered=0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public void input(DigitalVideoDisc disc, Scanner scanner, Session session){
        boolean check=false;
        System.out.println("Input title: ");
        disc.setTitle(scanner.nextLine());
        System.out.println("Input category: ");
        disc.setCategory(scanner.nextLine());
        System.out.println("Input director: ");
        disc.setDirector(scanner.nextLine());
        while (!check){
            try {
                System.out.println("Input length: ");
                disc.setLength(Integer.parseInt(scanner.nextLine()));
                check=true;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input. Please try again");
            }
        }
        check=false;
        while (!check){
            try {
                System.out.println("Input cost: ");
                disc.setCost(Float.parseFloat(scanner.nextLine()));
                if(disc.getCost()<=0){
                    System.out.println("Invalid input. Please try again");
                    continue;
                }
                check=true;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input. Please try again");
            }
        }

        try{
            session.save(disc);
            session.getTransaction().commit();
            //dvdRepository.save(disc);
            System.out.println("Add success");
        }catch (Exception e){
            //System.out.println();
            e.printStackTrace();
        }
    }

    public void removeDigitalVideoDisc(Session session,Scanner scanner){
        int id = 0;
        boolean check=false;
        while (!check){
            try {
                System.out.println("Input video's id what you want to delete: ");
                id=Integer.parseInt(scanner.nextLine());
                check=true;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input. Please try again");
            }
        }
        String queryString ="DELETE FROM DigitalVideoDisc WHERE id = :id";
        Query query =session.createQuery(queryString);
        query.setParameter("id",id);
        int res=query.executeUpdate();
        System.out.println(res);
        session.getTransaction().commit();
    }

    public double totalCost(Session session){
        String stringQuery="SELECT SUM(cost) FROM DigitalVideoDisc";
        Query query= session.createQuery(stringQuery);
        Double res= (Double) query.list().get(0);
        return res;
    }

    public void list(Session session){
        Criteria dvd=session.createCriteria(DigitalVideoDisc.class);
        String stringQuery="FROM DigitalVideoDisc D";
        Query query=session.createQuery(stringQuery);
        List<DigitalVideoDisc> res=query.list();
        System.out.println("List of video: ");
        for(DigitalVideoDisc disc1:res){
            System.out.println(disc1.toString());
        }
    }
}

