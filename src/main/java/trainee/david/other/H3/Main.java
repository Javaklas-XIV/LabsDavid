package trainee.david.other.H3;

public class Main {

    private enum Weekday {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    public static void main(String[] args){
        System.out.println(Weekday.MONDAY);

        overflow();
        Trainee david = createTrainee("David", "Koens");
        iPlus();
        int j = calculateJ(3);
        whatsTheTime(23, 80);

        System.out.println("Byte max: " + Byte.MAX_VALUE + " - min: " + Byte.MIN_VALUE);
        System.out.println("Short max: " + Short.MAX_VALUE + " - min: " + Short.MIN_VALUE);
        System.out.println("Integer max: " + Integer.MAX_VALUE + " - min: " + Integer.MIN_VALUE);
        System.out.println("Long max: " + Long.MAX_VALUE + " - min: " + Long.MIN_VALUE);
        System.out.println("Float max: " + Float.MAX_VALUE + " - min: " + Float.MIN_VALUE);
        System.out.println("Double max: " + Double.MAX_VALUE + " - min: " + Double.MIN_VALUE);

        Trainee jan = new Trainee("Jan", "Twee");
        jan = david;
        jan.setFirstName("Joris");
        System.out.println(david.getFirstName());
    }

    public static void overflow(){
        int number = Integer.MAX_VALUE;
        System.out.println("Number: " + number);
        System.out.println("Overflow: " + (number + 1));

        long numberFix = Integer.MAX_VALUE;
        System.out.println("Number fix: " + numberFix);
        System.out.println("Overflow Fix: " + (numberFix + 1));
    }

    public static Trainee createTrainee(String firstName, String lastName){
        Trainee david = new Trainee(firstName, lastName);
        System.out.println(david);
        return david;
    }

    public static void iPlus(){
        int i = 10;
        System.out.println("i: " + i);
        System.out.println("i++: " + i++);
        System.out.println("++i: " + ++i);
    }

    public static int calculateJ(int i){
        // ++i = 4 -> 0100 -> bitshift by 1 -> 0010 -> 2
        int j = (i < 3) ? i++ + ++i : ++i >>> 1;
        System.out.println("j: " + j);
        return j;
    }

    public static void binary(){
        byte b1 = 0b1010;
        byte b2 = 0b100;
        System.out.println("b1 + b2: " + (b1 ^ b2));
        System.out.println("b1 + b2: " + (b1 + b2));
    }

    public static void whatsTheTime(int start, int increment){
        int time = start + increment;
        int hour = time % 24;
        int days = increment / 24;
        System.out.println("Hour: " + hour + ":00" + "\nDays: " + days);
    }

}
