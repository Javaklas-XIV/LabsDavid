package trainee.david.other;

import java.util.Scanner;

import static java.lang.Math.abs;

public class H2 {

    public static void run(){
        int plusTwo = abs(-2);
        System.out.println("Plus two: " + plusTwo);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String userName = in.nextLine();
        System.out.println("Username is: " + userName);
    }

}
