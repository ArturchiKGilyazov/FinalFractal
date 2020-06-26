
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;

public class Main extends Application{

    private double width = 900;
    private double heigth = 600;


    //Множество мандельброта: zk=(zk-1)^2 + z0
    public static void main(String[] argv) {
        Application.launch(argv);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Group root = new Group(); Не подходит, двумя форами
        FlowPane root = new FlowPane(); //Поочерёдно впихивает объекты
        Scene scene = new Scene(root);  //представление спектакля
        Canvas canvas = new Canvas(width, heigth);  //средство для нанесение картинок/фигур
        Pixels pixels = new Pixels();
        GraphicsContext context = canvas.getGraphicsContext2D();                 //добавляет апдейты к класссу canvas(drow)
        PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();//Интерфейс для опреедления методов записи пикселей

        root.setAlignment(Pos.BOTTOM_CENTER);    //2 lesson/Пример с воронами
        root.getChildren().add(canvas); //К руту добавляем конвас, который добавляется к представлению

        Render.render(context, 0,0, width, heigth, pixels, 1);      //cerf static требует
        Render.draw(pixelWriter, pixels);

        Mouse mouse = new Mouse(width, heigth);

        //пробуем с мышкой
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                    mouse.setX(mouseEvent.getX());
                    mouse.setY(mouseEvent.getY());

                    int yourZoom = 2;   //переменная, которая показывает, на сколько мы должны увеличить картинку
                    mouse.getZooming(yourZoom);

                    mouse.update(mouse);
                    Render.render(context, mouse.getStartX(), mouse.getStartY(), mouse.getEndX(), mouse.getEndY(), pixels, mouse.getZoom());
                    Render.draw(pixelWriter, pixels);
                }
            }
        };

        canvas.setOnMouseClicked(eventHandler);

        stage.setTitle("Fractal");
        stage.setScene(scene);
        stage.show();
    }
}
