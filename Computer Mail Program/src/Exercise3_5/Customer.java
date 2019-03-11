package Exercise3_5;

public class Customer {
    public Customer(Bar bar){
        try {
            this.wait(1000);
            bar.takeBeer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
