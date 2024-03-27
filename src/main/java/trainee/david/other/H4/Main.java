package trainee.david.other.H4;

import java.util.Scanner;

public class Main {

    private static String bankAccountNumber;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        printTable(7, 10);

        System.out.print("Enter a bank account number: ");
        bankAccountNumber = input.nextLine();

        try {
            isValidBankAccount();
            System.out.println("This is a valid bank account");
        } catch (IllegalArgumentException i){
            System.out.println("This is an invalid bank account");
        }
    }

    private static void isValidBankAccount() throws IllegalArgumentException {
        if (bankAccountNumber.length() != 12) throw new IllegalArgumentException();

        int sum = 0;
        int multiplier = 9;

        for (char c : bankAccountNumber.toCharArray()){
            if (c == '.') continue;
            sum += Integer.parseInt(String.valueOf(c)) * multiplier--;
        }

        if (sum % 11 != 0) throw new IllegalArgumentException();
    }

    private static int printTable(int table, int multiplier){
        System.out.printf("%d x %d = %d\n", multiplier, table, (multiplier * table));
        if (multiplier == 1) return table;
        else return printTable(table, multiplier - 1) + table;
    }

    private static void printTable(int table){
        for (int i = 1; i <= table; i++){
            System.out.printf("%d x %d = %d\n", i, table, (i * table));
        }
    }

}
