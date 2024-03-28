package trainee.david.other.H10;

public class Main {

    public static void main(String[] args) {
        Android android = new Android();
        android.charge(60);
        System.out.println(android.greet());
        android.charge(50);
        System.out.println(android.greet());
    }

}
