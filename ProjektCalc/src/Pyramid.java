public class Pyramid extends Volume{

    private double a,b,volume;

    public Pyramid(double a,double b) {
        this.a=a;
        this.b=b;
        this.volume = this.a*this.b;
    }
    public double getVolume(){
        return this.volume;
    }
}
