public class Square extends Area {

    private double a,b,area;

    public Square(double a,double b){
        this.a = a;
        this.b = b;
        this.area = this.a*this.b;
    }

    public double getArea(){

        return this.area;
    }
}
