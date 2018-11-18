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
    /*
    Current limitations:
        methods must have either 0 or 1 parameters
        available parameters:
            Color
        methods cannot return more than 3 primitive values or strings
    */
    @Override
    public void start(Stage primaryStage) {
        System.out.println("3");

        //----Components are initialized----//
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


        //----This section handles methods for OptionMethods----//
        OptionMethod[] methods = Stream.concat(Arrays.stream(paletteMethods), Arrays.stream(colorMethods)).filter(method -> {
            //Filters all methods with @Option annotation
            Option option = method.getAnnotation(Option.class);
            return option != null;
        }).map(method -> {//turns method elements into OptionMethod
            Option option = method.getAnnotation(Option.class);



            return new OptionMethod(option.value(),() -> {
                System.out.println(method.getName());
                Object object;
                int param = method.getParameterTypes().length;

                if(Arrays.asList(paletteMethods).contains(method)){
                    object = colorPalette;
                }else if(Arrays.asList(colorMethods).contains(method)){
                    object = colorPalette.getColor(menu.getItems().indexOf(menu.getValue()));
                }else{
                    object = null;
                }
                System.out.println(method);
                System.out.println(Arrays.asList(paletteMethods));
                System.out.println(Arrays.asList(colorMethods));
                try {
                    if(param == 0){
                        if(method.getReturnType().getSimpleName().toUpperCase().equals("INT")){
                            String reValue = (int) method.invoke(object)+"";
                            textRed.setText(reValue);


                        }else if(method.getReturnType().getSimpleName().toUpperCase().equals("BOOLEAN")){
                            String reValue = (boolean) method.invoke(object)+"";
                            textRed.setText(reValue);

                        }else if(method.getReturnType().getSimpleName().toUpperCase().equals("COLOR")){
                            Color reValue = (Color) method.invoke(object);
                            textRed.setText(reValue.getRed()+"");
                            textGreen.setText(reValue.getGreen()+"");
                            textBlue.setText(reValue.getBlue()+"");

                        }else{
                            method.invoke(object);
                        }
                    }
                    else if (param > 0){
                        int r = 0;
                        int g = 0;
                        int b = 0;
                        try{
                            r = Integer.parseInt(textRed.getText());
                            g = Integer.parseInt(textGreen.getText());
                            b = Integer.parseInt(textBlue.getText());
                        } catch (Exception e) {

                            e.printStackTrace();
                        }
                        method.invoke(object, new Color(r,g,b));

                        if(method.getReturnType().getSimpleName().toUpperCase().equals("INT")){
                            String reValue = (int) method.invoke(object, new Color(r,g,b)) + "";
                            textRed.setText(reValue);
                        }else if(method.getReturnType().getSimpleName().toUpperCase().equals("BOOLEAN")){
                            String reValue = (boolean) method.invoke(object, new Color(r,g,b))+"";
                            textRed.setText(reValue);
                        }else if(method.getReturnType().getSimpleName().toUpperCase().equals("COLOR")){
                            Color reValue = (Color) method.invoke(object, new Color(r,g,b));
                            textRed.setText(reValue.getRed()+"");
                            textGreen.setText(reValue.getGreen()+"");
                            textBlue.setText(reValue.getBlue()+"");
                        }else{
                            method.invoke(object, new Color(r,g,b));
                        }
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        }).toArray(OptionMethod[]::new);//Converts stream to array element

        for (OptionMethod method : methods) {
            menu2.getItems().add(method);
        }

        EventHandler<ActionEvent> execute = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(menu2.getValue() instanceof OptionMethod && menu2.getValue() != null){
                    ((OptionMethod) menu2.getValue()).invoke();

                    menu.getItems().clear(); //empties menu
                    Rectangle rect = new Rectangle();

                    for (int index = 0; index < colorPalette.getColors().size(); index++) //refills menu with colorPalette colors
                        rect.setFill(javafx.scene.paint.Color.rgb(colorPalette.getColor(index).getRed(), colorPalette.getColor(index).getGreen(), colorPalette.getColor(index).getBlue()));
                        rect.setHeight(20);
                        rect.setWidth(60);
                        menu.getItems().add(rect);
                        rect = null;
                    }
                }
        };

        //----Scene is initialized and adds most components----//
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
