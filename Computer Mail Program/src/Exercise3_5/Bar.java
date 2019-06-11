package Exercise3_5;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Bar implements Runnable{

    Bartender bartender = new Bartender(this);
    Customer customer = new Customer(this);
    Thread threadB = new Thread();

    boolean barOpen = true;
    int cap = 20;
    ArrayList<Beer> barList = new ArrayList<>();

    public void placeBeer(){
        if (barList.size() <= cap && barOpen == true){
            barList.add(new Beer());
        }
        return;
    }
    public void takeBeer(){
        if(barList.size()>0 && barOpen == true){
            barList.remove(barList.size()-1);
        }
        return;
    }

    @Override
    public void run() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                barOpen=false;
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,10000);
    }
}
