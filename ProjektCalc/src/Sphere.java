public class Sphere extends Volume {

    private double a,volume;

    public Sphere(double a) {
        this.a = a;
        this.volume = (3/4)*a*Math.pow(Math.PI,3);
    }

    public double getVolume(){
        return this.volume;
    }
}
