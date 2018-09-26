import java.util.Objects;

public class Color {
    private int red, green, blue;

    public Color(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    public void set(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public boolean isGray(){
        if (red==green&&green==blue){
            return true;
        }else{
            return false;
        }
    }

    public void mixWith(Color color2){
        this.red = (int)((this.red+color2.getRed())*0.5);
        this.green = (int)((this.green+color2.getGreen())*0.5);
        this.blue = (int)((this.blue+color2.getBlue())*0.5);
    }

    public Color copy(){
        return new Color(this.red, this.green, this.blue);
    }

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
}
