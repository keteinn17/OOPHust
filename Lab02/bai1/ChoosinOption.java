package bai1;

import javax.swing.*;

public class ChoosinOption {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        int option = JOptionPane.showConfirmDialog(null,"Do you want to change to the first class ticket?");
        String []options = new String[2];
        options[0]="I do";
        options[1]="I don't";
        JOptionPane.showMessageDialog(jFrame.getContentPane(),"You've chosen: "+ (option==JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }

    // neu cho cancel thi se hien ra message You've chosen No
}
