import java.util.ArrayList;
import java.util.Objects;

public class ColorPalette {

    private int maxColors;
    private ArrayList<Color> colorList;

    public ColorPalette(int MaxNumberOfColors){
        maxColors = MaxNumberOfColors;
        colorList = new ArrayList<Color>();
    }

    public int getMaxCoulours() {
        return maxColors;
    }

    //@Option("Add Color")
    public void  addColor(Color color1){
        if(maxColors == 0){
            colorList.add(color1);
        }else if(maxColors >= colorList.size()){
            colorList.add(color1);
        }else{
            System.out.println("Palette is full");
        }
    }

    //@Option("Get Color")
    public Color getColor(int index){
        if(index > maxColors && maxColors != 0 || index < 0){
            System.out.println("Index out of bounds");
            return null;
        } else if (index > colorList.size()){
            System.out.println("Index exceeds list element value, Max value is: " + (colorList.size()-1));
            return null;
        } else if (index >= 0){
            return colorList.get(index);
        } else {
            System.out.println("Undefined error");
            return null;
        }
    }
    public ArrayList<Color> getColors (){
        return this.colorList;
    }

    //@Option("Number Of Grey Colors")
    public int numberOfGray(){
        int numberGray = 0;

        for (int i = 0; i<colorList.size(); i++){
            if (colorList.get(i).isGray()){
                numberGray++;
            }
        }
        return numberGray;
    }

    public void mixColors(int index, Color color2){
        if(index <= maxColors && index >= 0){
            color2.mixWith(colorList.get(index));
        }else{
            System.out.println("Index out of bounds");
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorPalette that = (ColorPalette) o;
        return maxColors == that.maxColors &&
                Objects.equals(colorList, that.colorList);
    }

    public String toString() {
        return "ColorPalette:" +
                "maxColors=" + maxColors +
                ", colorList=" + colorList
                ;
    }
}
