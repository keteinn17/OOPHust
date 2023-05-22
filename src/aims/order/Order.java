package aims.order;

import aims.disc.DigitalVideoDisc;

import java.util.Date;
import java.util.Scanner;

public class Order {
    public static final int MAX_NUMBERS_ORDERED=10;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED+1];

    private int qtyOrdered=0;
    private Date dateOrdered;

    public static final int MAX_LIMITED_ORDERS=5;

    private static int nbOrders=0;
    public Order(){
        nbOrders++;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered() {
        this.dateOrdered = new Date();
    }

    public DigitalVideoDisc input(DigitalVideoDisc disc, Scanner scanner){
        if(nbOrders == MAX_LIMITED_ORDERS){
            System.out.println("Cannot order!");
            return null;
        }
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
        /*while (checkInt(inputLength)){
            System.out.println("Input length: ");
            inputLength=
        }*/
        return disc;
    }

    public int addDigitalVideoDisc(DigitalVideoDisc disc){
        if(nbOrders == MAX_LIMITED_ORDERS){
            System.out.println("Cannot order!");
            return 0;
        }
        if(qtyOrdered==MAX_NUMBERS_ORDERED){
            System.out.println("Order list is full. Can't add new item.");
            return 0;
        }
        if(checkDigitalVideo(disc)){
            qtyOrdered++;
            itemsOrdered[qtyOrdered]=disc;
            System.out.println("Add digital video success");
            return 1;
        }
        return 0;
    }

    public void addDigitalVideoDisc(Scanner scanner){
        if(nbOrders == MAX_LIMITED_ORDERS){
            System.out.println("Cannot order!");
            return;
        }
        if(qtyOrdered==MAX_NUMBERS_ORDERED){
            System.out.println("Order list is full. Can't add new item.");
            return;
        }
        int n = 0;
        boolean check=false;
        while(!check){
            try {
                System.out.println("Input number of video: ");
                n=Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            check=true;
        }
        DigitalVideoDisc[] dvdList = new DigitalVideoDisc[n];
        for(int i=0;i<n;i++){
            dvdList[i]=new DigitalVideoDisc();
            dvdList[i]=input(dvdList[i],scanner);
            int res=addDigitalVideoDisc(dvdList[i]);
            if(res==0) return;
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2, Scanner scanner){
        System.out.println("Add video 1: ");
        disc1=input(disc1,scanner);
        addDigitalVideoDisc(disc1);

        System.out.println("Add video 2: ");
        disc2=input(disc2,scanner);
        addDigitalVideoDisc(disc2);
    }


    public void removeDigitalVideoDisc(int req){
        if(qtyOrdered==0){
            return;
        }
        if(req<=0 || req>qtyOrdered){
            System.out.println("Invalid item!");
            return;
        }
        if(req-1==1){
            for(int i=1;i<qtyOrdered;i++){
                itemsOrdered[i]=itemsOrdered[i+1];
            }
            itemsOrdered[qtyOrdered]=null;
            System.out.println("Delete success!");
            qtyOrdered--;
            return;
        }

        for(int i=req-1;i<qtyOrdered;i++){
            itemsOrdered[i]=itemsOrdered[i+1];
        }
        itemsOrdered[qtyOrdered]=null;
        qtyOrdered--;
        System.out.println("Delete success!");
    }

    public float totalCost(){
        if(qtyOrdered==0){
            return 0;
        }
        float res=0;
        for (int i=1;i<=qtyOrdered;i++) {
            res += itemsOrdered[i].getCost();
        }
        return res;
    }

    public void list(){
        if(qtyOrdered==0){
            System.out.println("Order list is null!");
            return;
        }
        System.out.println("List of video: ");
        for(int i=1;i<qtyOrdered+1;i++){
            System.out.print((i)+ ": ");
            System.out.println(itemsOrdered[i].toString());
        }
    }

    public boolean search(String title){
        boolean res=false;
        for(int i=1;i<=qtyOrdered;i++){
            if(itemsOrdered[i].search(itemsOrdered[i],title)){
                res=true;
            }
        }
        return res;
    }
    public DigitalVideoDisc getALuckyItem(){
        if(qtyOrdered == 0) {
            System.out.println("Numbers's order is 0! Can't get lucky item");
            return null;
        }
        int ran= (int) (Math.random() * qtyOrdered) + 1;
        return itemsOrdered[ran];
    }
    private boolean checkDigitalVideo(DigitalVideoDisc disc){
        return disc != null;
    }
    private boolean checkInt(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean checkFloat(String input){
        try{
            Float.parseFloat(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
