package Exercise3_4;

public class CounterDecrementer implements Runnable{
    int updates;
    Counter counter;
    public CounterDecrementer(Counter counter, int updates){
        this.counter=counter;
        this.updates=updates;
    }
    @Override
    public void run() {
        for(int i=0; i<updates; i++){
            counter.decrement();
        }
        System.out.println(counter.getValue());
    }
}
