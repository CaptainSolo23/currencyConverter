import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to the Currency converter");

        String [] options = {"Currency", "Temperature"};
        int option = JOptionPane.showOptionDialog(null,"Choose an option", "Make a choice",
                0,JOptionPane.QUESTION_MESSAGE, null, options, "");
        System.out.println("La respuesta fue: " + option );
        System.out.println("La respuesta fue: " + options[option]);
    }
}