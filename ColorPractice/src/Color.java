import java.util.Objects;

public class Color {
    private int red, green, blue;

    public Color(int red, int green, int blue){
        this.red = red%256;
        this.green = green%256;
        this.blue = blue%256;
    }
    public void set(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Option("Get Red Value")
    public int getRed() {
        return red;
    }

    @Option("Get Green Value")
    public int getGreen() {
        return green;
    }

    @Option("Get Blue Value")
    public int getBlue() {
        return blue;
    }

    @Option("Is Gray")
    public boolean isGray(){
        if (red==green&&green==blue){
            return true;
        }else{
            return false;
        }
    }

    @Option("Mix With")
    public void mixWith(Color color2){
        this.red = (int)((this.red+color2.getRed())/2);
        this.green = (int)((this.green+color2.getGreen())/2);
        this.blue = (int)((this.blue+color2.getBlue())/2);
    }

    @Option("Copy Color")
    public Color copy(){
        return new Color(this.red, this.green, this.blue);
    }

    @Option("Has Designated Values")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return red == color.red &&
                green == color.green &&
                blue == color.blue;
    }

    public String toString() {
        return "Red: " + this.red + ", Green: " + this.green + ", Blue: " + this.blue;
    }


    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}
