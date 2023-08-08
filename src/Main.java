import javax.swing.*;
import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) {

        //APP START
        JOptionPane.showMessageDialog(null, "Welcome to the Currency/Temperature converter");

        String [] options = {"Currency", "Temperature"}; //Choice 1: Currency or Temp
        int option = JOptionPane.showOptionDialog(null,
                "Choose an option",
                "Make a choice",
                0,JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "");

        //Arrays and tools
        String [] currencyModes = {"From MXN","To MXN"};
        String [] currencyOptions = {"USD","EUR","CAN","GBP"};
        String [] tempModes = {"From C","To C"};
        String [] distModes = {"km to miles", "miles to km"};
        double result;
        DecimalFormat dFormat = new DecimalFormat("#.##");
        double amountToBeExchanged;
        double temp;
        double dist;

        //CURRENCY LOGIC
        if(option == 0){
            JOptionPane.showMessageDialog(null,
                    "You've chosen currency converter");
            option = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option",
                    "Make a choice",
                    0,JOptionPane.QUESTION_MESSAGE,
                    null,
                    currencyModes,
                    "");

            if(currencyModes[option].equals(currencyModes[0]) ){ // From MXN to Foreign Currency

                try {
                    amountToBeExchanged = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to be converted"));
                    if(amountToBeExchanged < 0){ // Catching possible negative numbers
                        throw new IllegalArgumentException("You must enter a valid positive number");
                    }
                    String currOpt = (String) JOptionPane.showInputDialog(
                            null,
                            "Choose a currency",
                            "Dropdown menu",
                            JOptionPane.QUESTION_MESSAGE,
                            null, currencyOptions,
                            currencyOptions[0]);

                    Converter.MxnToConverter mxnTo = new Converter.MxnToConverter(); //Initialize converter


                    switch (currOpt) {
                        case "USD":

                            result = mxnTo.convert(amountToBeExchanged, Converter.USD_RATE);
                            JOptionPane.showMessageDialog(null,
                                    amountToBeExchanged + " MXN equals: " + dFormat.format(result) + " USD");

                            break;
                        case "EUR":

                            result = mxnTo.convert(amountToBeExchanged, Converter.EUR_RATE);
                            JOptionPane.showMessageDialog(null,
                                    amountToBeExchanged + " MXN equals: " + dFormat.format(result) + " EUR");

                            break;
                        case "CAN":

                            result = mxnTo.convert(amountToBeExchanged, Converter.CAN_RATE);
                            JOptionPane.showMessageDialog(null,
                                    amountToBeExchanged + " MXN equals: " + dFormat.format(result) + " CAN");

                            break;
                        case "GBP":

                            result = mxnTo.convert(amountToBeExchanged, Converter.GBP_RATE);
                            JOptionPane.showMessageDialog(null,
                                    amountToBeExchanged + " MXN equals: " + dFormat.format(result) + " GBP");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,
                                    "Invalid option.");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "You must enter a valid positive number");
                }
                catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
                }

                } else if(currencyModes[option].equals(currencyModes[1]) ){  // convertir a Mxn

                try {
                    amountToBeExchanged = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad que quieres convertir"));
                    if(amountToBeExchanged < 0){ // Catching possible negative numbers
                        throw new IllegalArgumentException("You must enter a valid positive number");
                    }
                    String currOpt = (String) JOptionPane.showInputDialog(
                            null,
                            "Choose a currency",
                            "Dropdown menu",
                            JOptionPane.QUESTION_MESSAGE,
                            null, currencyOptions,
                            currencyOptions[0]);

                    Converter.ConvertToMxn toMxn = new Converter.ConvertToMxn(); // Initialize converter

                    switch (currOpt) {
                        case "USD":
                            result = toMxn.convert(amountToBeExchanged, Converter.USD_RATE);
                            JOptionPane.showMessageDialog(null,
                                    amountToBeExchanged + " USD equals: " + dFormat.format(result) + " MXN");
                            break;
                        case "EUR":

                            result = toMxn.convert(amountToBeExchanged, Converter.EUR_RATE);
                            JOptionPane.showMessageDialog(null,
                                    amountToBeExchanged + " EUR equals: " + dFormat.format(result) + " MXN");

                            break;
                        case "CAN":


                            result = toMxn.convert(amountToBeExchanged, Converter.CAN_RATE);
                            JOptionPane.showMessageDialog(null,
                                    amountToBeExchanged + " CAN equals: " + dFormat.format(result) + " MXN");

                            break;
                        case "GBP":

                            result = toMxn.convert(amountToBeExchanged, Converter.GBP_RATE);
                            JOptionPane.showMessageDialog(null,
                                    amountToBeExchanged + " GBP equals: " + dFormat.format(result) + " MXN");

                            break;
                        default:
                            JOptionPane.showMessageDialog(null,
                                    "Invalid option.");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Error: You must enter a valid a positive number");
                }
                catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "No currency selected.");
            }

        // TEMPERATURE CONVERTER
        } else {
            JOptionPane.showMessageDialog(null,
                    "You've chosen temperature converter");
            option = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option",
                    "Make a choice",
                    0,JOptionPane.QUESTION_MESSAGE,
                    null,
                    tempModes,
                    "");


            if(tempModes[option].equals(tempModes[0]) ){ // From C to F

                try {
                    temp = Double.parseDouble(JOptionPane.showInputDialog("Enter the temperature to be converted"));
                    double convertedTemp = TempConverter.celsiusToFahrenheit(temp);
                    JOptionPane.showMessageDialog(null, temp + "C equals: " + (int) convertedTemp + "F");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Error: You must enter a valid number");
                }
            } else {
                try {
                    temp = Double.parseDouble(JOptionPane.showInputDialog("Enter the temperature to be converted"));
                    double convertedTemp = TempConverter.fahrenheitToCelsius(temp);
                    JOptionPane.showMessageDialog(null, temp + "F equals: " + dFormat.format(convertedTemp) + "C");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Error: You must enter a valid number");
                }
            }
        }
        //DISTANCE CONVERTER
        JOptionPane.showMessageDialog(null,
                "Try our distance converter");
        option = JOptionPane.showOptionDialog(
                null,
                "Choose an option",
                "Make a choice",
                0,JOptionPane.QUESTION_MESSAGE,
                null,
                distModes,
                "");

        if(tempModes[option].equals(distModes[0]) ){ // km to miles

            try {
                dist = Double.parseDouble(JOptionPane.showInputDialog("Enter the distance to be converted"));
                double convertedDist = DistanceConverter.kmToMiles(dist);
                JOptionPane.showMessageDialog(null,
                        dist + "km equals: " + dFormat.format(convertedDist) + " miles");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: You must enter a valid number");
            }
        } else {
            try {
                dist = Double.parseDouble(JOptionPane.showInputDialog("Enter the distance to be converted"));
                double convertedDist = DistanceConverter.milesToKm(dist);
                JOptionPane.showMessageDialog(null,
                        dist + " miles equals: " + dFormat.format(convertedDist) + "km");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: You must enter a valid number");
            }
        }
        JOptionPane.showMessageDialog(null,
                "Thanks for using my first Java App");
    }
}