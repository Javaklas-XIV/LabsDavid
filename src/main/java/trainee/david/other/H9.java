package trainee.david.other;

public class H9 {

    public static void run(){
        System.gc();
        // The finalizer is called when there are no more references to this object and it can be garbage collected
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        // Don't use this if at all possible
        // Also it's deprecated
    }
}
