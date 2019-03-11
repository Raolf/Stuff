package Exersice3_3;

public class Mailbox extends Thread {
    long maxFrequency;
    int count;
    long RUNTIME = 100000;

    public Mailbox(int count){
        this.count = count;
        maxFrequency = RUNTIME/count;
    }

    public void run(){
        for(int i = 0; i<count;i++){
            System.out.println(count + "New mail in box");
            try {
                Thread.sleep(maxFrequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void waitingForMails(){

    }

}
