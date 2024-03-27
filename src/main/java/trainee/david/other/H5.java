package trainee.david.other;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class H5 {

    public static void run(){
        System.out.println("5 || 4 : " + greatest(5, 4));
        System.out.println("Hoi || Hallo : " + greatest("Hoi", "Hallo"));
        System.out.println("1 || 2 || 3 : " + greatest(1, 2, 3));

        System.out.println("5! = " + factorial(5));
    }

    private static int greatest(int a, int b){
        return Math.max(a, b);
    }

    private static String greatest(String a, String b){
        return (a.length() > b.length()) ? a : b;
    }

    private static int greatest(int... numbers){
        OptionalInt max = Arrays.stream(numbers).max();
        if (max.isPresent()) return max.getAsInt();
        return -1;
    }

    private static int factorial(int start){
        if (start == 1) return 1;
        else return factorial(start - 1) * start;
    }

}
