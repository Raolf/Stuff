import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.w3c.dom.css.Rect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class Canvas extends Application {
    ColorPalette colorPalette = new ColorPalette(0);

    public Canvas(){

    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("3");

        ComboBox menu = new ComboBox();
        javafx.scene.control.Label labelMenu = new javafx.scene.control.Label("Colors:");

        ComboBox menu2 = new ComboBox();
        javafx.scene.control.Label optionsMenu = new javafx.scene.control.Label("Options:");

        Method[] paletteMethods = ColorPalette.class.getDeclaredMethods();
        Method[] colorMethods = Color.class.getDeclaredMethods();

        TextField textName = new TextField();
        javafx.scene.control.Label labelName = new javafx.scene.control.Label("Name:");

        TextField textRed = new TextField();
        javafx.scene.control.Label labelRed = new javafx.scene.control.Label("Red:");

        TextField textGreen = new TextField();
        javafx.scene.control.Label labelGreen = new javafx.scene.control.Label("Green:");

        TextField textBlue = new TextField();
        javafx.scene.control.Label labelBlue = new javafx.scene.control.Label("Blue:");


        OptionMethod a1 = new OptionMethod("Add Color",()->{

            int r = Integer.parseInt(textRed.getText());
            int g = Integer.parseInt(textGreen.getText());
            int b = Integer.parseInt(textBlue.getText());

            colorPalette.addColor(new Color(r,g,b));

            System.out.println(colorPalette.getColors().get(colorPalette.getColors().size()-1));
        });

        OptionMethod a2 = new OptionMethod("Get Color",()->{

            int r = Integer.parseInt(textRed.getText());
            Color color = colorPalette.getColor(r);

            textRed.setText(""+color.getRed());
            textGreen.setText(""+color.getGreen());
            textBlue.setText(""+color.getBlue());


            System.out.println(colorPalette.getColors().get(colorPalette.getColors().size()-1));
        });

        menu2.getItems().add(a1);

        OptionMethod[] methods = Stream.concat(Arrays.stream(paletteMethods), Arrays.stream(colorMethods)).filter(method -> {
            //Filters all methods that with @Option annotation
            Option option = method.getAnnotation(Option.class);
            return option != null;
        }).map(method -> {
            Option option = method.getAnnotation(Option.class);

            Object object;

            if(Arrays.asList(paletteMethods).contains(method)){
                object = colorPalette;
            }else if(Arrays.asList(colorMethods).contains(method)){
                object = menu.getValue();
            }else{
                object = null;
            }
            return new OptionMethod(option.value(),() -> {
                System.out.println(method.getName());
                try {
                    method.invoke(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        }).toArray(OptionMethod[]::new);

        for (OptionMethod method : methods) {
            menu2.getItems().add(method);
        }

        EventHandler<ActionEvent> execute = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(menu2.getValue() instanceof OptionMethod){
                    ((OptionMethod) menu2.getValue()).invoke();
                }

                menu.getItems().removeAll();
                for (int index = 0; index < colorPalette.getColors().size(); index++)
                    menu.getItems().add(colorPalette.getColor(index));
                }
        };

        javafx.scene.control.Button button = new javafx.scene.control.Button("Execute");
        button.setOnAction(execute);

        HBox panel = new HBox();
        panel.setSpacing(10);
        panel.getChildren().addAll(labelMenu, menu, optionsMenu, menu2, button);


        VBox vBox = new VBox();
        Group group = new Group();
        vBox.getChildren().addAll(panel, labelRed, textRed, labelGreen, textGreen, labelBlue, textBlue);

        Scene scene = new Scene(vBox,400,450);
        primaryStage.setTitle("Color Window");
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("4");
    }
}
