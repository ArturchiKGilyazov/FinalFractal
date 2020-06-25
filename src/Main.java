import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application{

    private double width = 1024;
    private double heigth = 1024;


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
        Render.render(context, width, heigth, pixels);      //cerf static требует
        Render.draw(pixelWriter, pixels);


        stage.setTitle("Fractal");
        stage.setScene(scene);
        stage.show();
    }
}
