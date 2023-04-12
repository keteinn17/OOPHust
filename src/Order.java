import java.util.InputMismatchException;
import java.util.Scanner;

public class Order {
    public static final int MAX_NUMBERS_ORDERED=10;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered=0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public DigitalVideoDisc input(DigitalVideoDisc disc, Scanner scanner){
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

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered==MAX_NUMBERS_ORDERED){
            System.out.println("Order list is full. Can't add new item.");
            return;
        }
        if(checkDigitalVideo(disc)){
            qtyOrdered++;
            itemsOrdered[qtyOrdered]=disc;
            System.out.println("Add digital video success");
        }
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
