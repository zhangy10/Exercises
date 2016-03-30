package MultiTasking;

public class SyncThread {
    
    public static void main(String[] args) {
        Printer p1 = new Printer("Main");
        Printer p2 = new Printer("Second");
        
        new Thread(p2).start();
        new Thread(p1).start();
    }
    
}


class Printer implements Runnable {
    
    private String str;
    
    public Printer(String output) {
        this.str = output;
    }

    @Override
    public void run() {
        
        synchronized(System.out) {
            for (int i = 0; i < 15; i++) {
                System.out.println(str);
            }
        }
    }
    
}
