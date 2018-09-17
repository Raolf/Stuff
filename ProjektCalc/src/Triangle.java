public class Triangle extends Area {

    private double a,b,c,s,area;

    public Triangle (double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = (a+b+c)/2;
        this.area = Math.sqrt(s*(s-a)*(s-b)*(s-c));

    }
    public double getArea(){

        return this.area;
    }

}
