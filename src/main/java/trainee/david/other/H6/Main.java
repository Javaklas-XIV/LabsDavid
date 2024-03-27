package trainee.david.other.H6;

public class Main {

    public static void main(String[] args){
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;

        System.out.println(row[2]);

        int[] old = new int[]{1, 2, 3, 4};
        int[] result = doubleArray(old);
        for (int i : result) System.out.println(i);

        long[] longResult = new long[]{1L, 2L, 3L};
        multiply(longResult, 2);
        for (long number : longResult) System.out.println(number);
    }

    private static int[] doubleArray(int[] old){
        int[] newArr = new int[old.length * 2];
        for (int index = 0; index < newArr.length; index++){
            if (index < old.length) newArr[index] = old[index];
            else newArr[index] = 0;
        }
        return newArr;
    }

    private static void multiply(long[] input, int multiplier){
        for (int index = 0; index < input.length; index++){
            input[index] = input[index] * multiplier;
        }
    }

}
