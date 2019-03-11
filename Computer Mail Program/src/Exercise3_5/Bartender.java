package Exercise3_5;

public class Bartender {

    public Bartender(Bar bar){
        try {
            this.wait(1000);
            bar.placeBeer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
