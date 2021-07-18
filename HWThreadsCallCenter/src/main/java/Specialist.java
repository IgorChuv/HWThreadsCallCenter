import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Queue;

public class Specialist implements Runnable {

    private static final int timeToReceive = 1000;
    private static final int timeToProcessing = 1000;

    private final Queue<String> callsQueue;

    public Specialist(Queue<String> calls) {
        this.callsQueue = calls;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(timeToReceive);
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss "))
                    + Thread.currentThread().getName() + " начал работу.");

            while(!callsQueue.isEmpty()) {
                String call = callsQueue.poll();
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss "))
                        + Thread.currentThread().getName() + " принял в обработку номер: " + call);
                Thread.sleep(timeToProcessing);
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss "))
                        + Thread.currentThread().getName() + " обработал номер: " + call);
            }
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss "))
                    + Thread.currentThread().getName() + " закончил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
