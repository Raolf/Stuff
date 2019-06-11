package Exercise3_4;

public class Counter {

    long value;
    long max;
    long min;

    public Counter(long min, long max){
        value=0;
        this.min=min;
        this.max=max;
    }
    public void increment(){
        if (value >= max){
            while (true){}
        }else{
            value++;
        }
    }
    public void decrement(){
        if (value <= max){
            while (true){}
        }else{
            value--;
        }
    }
    public long getValue(){
        return value;
    }

}
