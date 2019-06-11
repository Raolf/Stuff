package Exersice3_3;

public class Computer {

    public static void main(String[] args) {
    Mailbox mailbox = new Mailbox(2);
    Program program = new Program("Trojan","take over your device",1);
    mailbox.start();
    program.start();
    }
}
