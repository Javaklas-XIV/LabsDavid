package trainee.david.other.H5;

public class Fibo {

    /**
     * Calculate a fibonacci number recursively
     * @param number The fibonacci number to calculate
     * @return The resulting fibonacci number
     */
    public static long runRec(long number){
        return (number <= 1) ? 1 : runRec(number - 1) + runRec(number - 2);
    }

    /**
     * Calculate a fibonacci number using a loop
     * @param number The fibonacci number to calculate
     * @return The resulting fibonacci number
     */
//    public static long run(long number){
//        return run(1, number);
//    }

    public static long run(long start, long number){
        return run(0, start, number);
    }

    public static long run(long start1, long start2, long number){
        long previous = start1;
        long beforePrevious = start2;
        long result = 0;
        for (long iteration = 0; iteration < number; iteration++){
            result = previous + beforePrevious;
            previous = beforePrevious;
            beforePrevious = result;
            System.out.println(result);
        }
        return result;
    }

    public static long[] run(int number){
        long previous = 1;
        long beforePrevious = 0;
        long[] result = new long[number];

        for (int iteration = 0; iteration < number; iteration++){
            result[iteration] = previous + beforePrevious;
            previous = beforePrevious;
            beforePrevious = result[iteration];
        }

        for (long fNumber : result) System.out.println(fNumber);

        return result;
    }

}
