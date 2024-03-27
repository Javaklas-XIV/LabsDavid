package trainee.david.other.H2;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args){
        int plusTwo = abs(-2);
        System.out.println("Plus two: " + plusTwo);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String userName = in.nextLine();
        System.out.println("Username is: " + userName);
    }

}
