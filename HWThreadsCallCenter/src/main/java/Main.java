import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static Queue<String> callsQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {
        new Thread(new AutomaticTelephoneExchange(callsQueue)).start();
        new Thread(new Specialist(callsQueue), "Специалист 1").start();
        new Thread(new Specialist(callsQueue), "Специалист 2").start();
        new Thread(new Specialist(callsQueue), "Специалист 3").start();
    }
}
