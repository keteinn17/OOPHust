package aims.order;

import aims.media.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Order {
    public static final int MAX_NUMBERS_ORDERED=10;


    private int qtyOrdered=0;
    private Date dateOrdered;

    private  List<Media> itemsOrdered=new ArrayList<>();
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


    public <T> T input(T t, Scanner scanner){
        if(nbOrders == MAX_LIMITED_ORDERS){
            System.out.println("Cannot order!");
            return null;
        }

        if(t instanceof DigitalVideoDisc){
            DigitalVideoDisc disc = new DigitalVideoDisc();
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
            itemsOrdered.add(disc);
            return (T) disc;
        }else if(t instanceof Book){
            Book book =new Book();
            boolean check=false;
            System.out.println("Input title: ");
            book.setTitle(scanner.nextLine());
            System.out.println("Input category: ");
            book.setCategory(scanner.nextLine());
            while (!check){
                try {
                    System.out.println("Input cost: ");
                    book.setCost(Float.parseFloat(scanner.nextLine()));
                    if(book.getCost()<=0){
                        System.out.println("Invalid input. Please try again");
                        continue;
                    }
                    check=true;
                }catch (NumberFormatException exception){
                    System.out.println("Invalid input. Please try again");
                }
            }
            itemsOrdered.add(book);
            return (T) book;
        }else if(t instanceof CompactDisc){
            CompactDisc compactDisc = new CompactDisc();
            boolean check=false;
            System.out.println("Input title: ");
            compactDisc.setTitle(scanner.nextLine());
            System.out.println("Input category: ");
            compactDisc.setCategory(scanner.nextLine());
            System.out.println("Input director: ");
            compactDisc.setDirector(scanner.nextLine());
            check=false;
            while (!check){
                try {
                    System.out.println("Input cost: ");
                    compactDisc.setCost(Float.parseFloat(scanner.nextLine()));
                    if(compactDisc.getCost()<=0){
                        System.out.println("Invalid input. Please try again");
                        continue;
                    }
                    check=true;
                }catch (NumberFormatException exception){
                    System.out.println("Invalid input. Please try again");
                }
            }
            System.out.println("Input artist: ");
            compactDisc.setArtist(scanner.nextLine());

            itemsOrdered.add(compactDisc);
            return (T) compactDisc;
        }
        return null;
    }

    public void addTrack(CompactDisc CD, Track track){
        track=new Track();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input track's title: ");
        track.setTitle(scanner.nextLine());
        boolean check=false;
        while (!check){
            try {
                System.out.println("Input length: ");
                track.setLength(Integer.parseInt(scanner.nextLine()));
                if(track.getLength()<=0){
                    System.out.println("Invalid input. Please try again");
                    continue;
                }
                check=true;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input. Please try again");
            }
        }
        CD.addTrack(track);
        System.out.println("Add success");
    }

    public void removeMedia(int input){
        int index = input - 1;
        if(index >= itemsOrdered.size() || index < 0){
            System.out.println("Invalid input!");
            return;
        }
        itemsOrdered.remove(index);
        System.out.println("Remove successfully");
    }

    public float totalCost(){
        if(itemsOrdered.isEmpty()){
            System.out.println("Order list is null");
            return 0;
        }
        float res=0;
        for(Media media:itemsOrdered){
            res+=media.getCost();
        }
        return res;
    }

    public void list(){
        if(itemsOrdered.isEmpty()){
            System.out.println("Order list is null");
            return;
        }
        System.out.println("List of video: ");
        int i=0;
        for(Media media:itemsOrdered){
            i++;
            System.out.print(i +": ");
            System.out.println(media.toString());
        }
    }

    public boolean search(String title){
        boolean res=false;
        for(Media media:itemsOrdered){
            if(media.getTitle().toLowerCase().contains(title.toLowerCase())){
                return true;
            }
        }
        return res;
    }
    public void getALuckyItem(){
        if(itemsOrdered.size() == 0) {
            System.out.println("Numbers's order is 0! Can't get lucky item");
            return;
        }
        int ran= (int) (Math.random() * itemsOrdered.size()) + 1;
        System.out.println(itemsOrdered.get(ran).toString());
    }
}
