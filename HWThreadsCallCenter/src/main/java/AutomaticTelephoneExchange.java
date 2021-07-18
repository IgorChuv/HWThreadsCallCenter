import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Queue;

public class AutomaticTelephoneExchange implements Runnable {

    private static int callsPerDay = 0;
    private static final int maxCallsPerDay = 10;
    private static final int timeOut = 3000;

    private static final PhoneNumberGenerator phoneNumberGenerator = new PhoneNumberGenerator();
    private final Queue<String> callsQueue;

    public AutomaticTelephoneExchange(Queue<String> calls) {
        this.callsQueue = calls;
    }

    @Override
    public void run() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " АТС начала работу.");

        try {
            while(callsPerDay < maxCallsPerDay) {
                for (int i = 0; i < 10; i++) {
                    String call = phoneNumberGenerator.generate();
                    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " Поступил звонок с номера: " + call);
                    callsQueue.add(call);
                }
                callsPerDay++;
                Thread.sleep(timeOut);
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}