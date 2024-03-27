package trainee.david.other.H9;

public class Main {

    public static void main(String[] args){
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
