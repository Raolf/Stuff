import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.Global;
import sun.plugin2.util.ColorUtil;

public class Main extends Application {



    @Override public void start(Stage stage) {
        Canvas canvas = new Canvas();

        Rectangle2D Screen = javafx.stage.Screen.getPrimary().getVisualBounds();

        stage.setMaxHeight(Screen.getHeight());
        stage.setMaxWidth(Screen.getWidth());
        stage.setX(0);
        stage.setY(0);
        stage.setTitle("Tower Of Hanoi");
        stage.setScene(canvas.getScene());
        stage.sizeToScene();
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }
}
