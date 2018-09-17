public class Box extends Volume {

    private double a,b,c,volume;

    public Box(double a,double b,double c) {
        this.a=a;
        this.b=b;
        this.c=c;
        this.volume=a*b*c;
    }
    public double getVolume(){
        return this.volume;
    }

}
