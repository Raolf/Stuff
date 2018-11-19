import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import jdk.nashorn.internal.objects.Global;
import sun.plugin2.util.ColorUtil;

import java.util.ArrayList;

public class Canvas{
    private static String[] arguments;
    int sizeY=0;
    public Group rect = new Group();
    public Rectangle tempRec;
    private Board board;
    private Scene scene;

    Disk selectedDisk = null;
    int height = 600;
    int width = 1000;

    public Canvas() {

        arguments = new String[2];
        //------TEMP--------
         arguments[0] = "10";
        //------TEMP--------

        try{
            if(arguments.length>0){
                System.out.println(arguments[0]);
                sizeY = Integer.parseInt(arguments[0]);
            }

        }catch(Exception e){
            System.out.println("Canvas Arguments " + e);
        }
        
        board = new Board(sizeY);
        board.setCanvas(this);


        System.out.println(board.getDisks().size());
        for (int i = 0; i<=board.getDisks().size(); i++){
            Rectangle rectangle = new Rectangle(20*i,10);
            int red = (210*i%256);
            int green = (220*i%256);
            int blue = (230*i%256);

            rectangle.setX((sizeY-20*i)/2+width/3.0-1/6.0*width);

            rectangle.setY(height-sizeY*10+(i-1)*10);

            rectangle.setFill(Color.rgb(red, green, blue));
            rect.getChildren().add(rectangle);
        }


        Scene scene = new Scene(rect,width,height);
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                int stackArea = 1;
                if (event.getX() > (1/3.0)*getScene().getWidth()){
                    if (event.getX() < (2/3.0)*getScene().getWidth()){
                        stackArea = 2;
                    }else {
                        stackArea = 3;
                    }
                }else{
                    stackArea = 1;
                }

                if(selectedDisk == null){
                    selectedDisk = board.getStack(stackArea-1).getTopDisk();
                }else{
                    selectedDisk.move(board.getStack(stackArea-1));
                    selectedDisk = null;
                }
            }
        });

        this.scene = scene;
        }

    public void Update (Disk disk, Stack stack){

        tempRec = (Rectangle) rect.getChildren().get(disk.getSize());

        tempRec.setX((sizeY-20*disk.getSize())/2+(width*stack.getIndex())/3.0+1/6.0*width);
        tempRec.setY(height-disk.getPos()*10);

        rect.getChildren().remove(disk.getSize());
        rect.getChildren().add(disk.getSize(), tempRec);
    }
    public Board getBoard () {
        return board;
    }

    public Scene getScene(){
        return this.scene;
    }


}