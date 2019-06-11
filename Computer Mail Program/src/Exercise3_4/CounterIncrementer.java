package Exercise3_4;

public class CounterIncrementer implements Runnable{
    int updates;
    Counter counter;
    public CounterIncrementer(Counter counter, int updates){
        this.counter=counter;
        this.updates=updates;
    }
    @Override
    public void run() {
        for(int i=0; i<updates; i++){
            counter.increment();
        }
        System.out.println(counter.getValue());
    }
}
