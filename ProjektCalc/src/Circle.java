public class Circle extends Area {

    private double a,area;

    public Circle(double a) {
        this.a = a;
        this.area = a*Math.pow(Math.PI,2);
    }

    public double getArea(){

        return this.area;
    }

}
