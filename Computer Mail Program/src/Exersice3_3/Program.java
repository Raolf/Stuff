package Exersice3_3;

public class Program extends Thread {
    String program;
    long maxFrequency;
    String action;
    int count;
    long RUNTIME;

    public Program(String program, String action, int count){
        this.program = program;
        this.action = action;
        this.count = count;
        maxFrequency = RUNTIME/count;
    }
    public void run(){
        for(int i = 0; i<count; i++){
            System.out.println(program+" wants to "+action);
            try {
                Thread.sleep(maxFrequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void normalOperation(){

    }
}
