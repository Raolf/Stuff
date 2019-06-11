package Exercise3_4;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter(0,200);
        CounterIncrementer counterIncrementer = new CounterIncrementer(counter, 20);
        CounterDecrementer counterDecrementer = new CounterDecrementer(counter, 20);

        Thread thread1 = new Thread(counterIncrementer);
        Thread thread2 = new Thread(counterDecrementer);

        thread1.start();
        thread2.start();
    }
}
