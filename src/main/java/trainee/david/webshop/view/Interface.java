package trainee.david.webshop.view;

import java.util.Scanner;

public class Interface {

    private static final int INTERFACE_SIZE = 40;
    private final Scanner userInput;

    public Interface(){
        userInput = new Scanner(System.in);
    }

    protected void printMenuHeader(String title){
        int remainingChars = INTERFACE_SIZE - title.length();
        String halfHeader = "=".repeat(remainingChars / 2);
        System.out.println("\n" + halfHeader + title + halfHeader);
    }

    protected void printLine(String line){
        int remainingChars = INTERFACE_SIZE - 4;
        String padding = " ".repeat(Math.max(0, remainingChars - line.length()));

        System.out.println("| " + line + padding + " |");
    }

    protected String getUserInput(String prompt){
        System.out.print("- " + prompt);
        return userInput.nextLine();
    }

    protected int validMenuInput(String input, int totalMenuOptions) {
        try {
            int result = Integer.parseInt(input);
            return (result >= 0 && result < totalMenuOptions) ? result : -1;
        } catch (NumberFormatException n) {
            // The input didn't contain a number
            System.out.println("Geen geldige invoer");
            return -1;
        }
    }

    protected void show(){

    }

}
