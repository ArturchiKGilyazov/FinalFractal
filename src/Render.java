import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Render {


    public static void render(GraphicsContext gc, double width, double height, Pixels pixels){

        double length = 400;    //Длинна пиксельного единичного отрезка

        //Потому что у нас координатная плоскость начинается не с левого верхнего угла, мы должны сдвигать её
        double rX = 2 * width / 3;
        double rY = height / 2;

        for(double i = 0; i < width; i++){
            for (double j = 0; j < height; j++){
                double x = (i - rX) / length;
                double y = (j - rY) / length;

                Intensivity z = new Intensivity(x, y);
                int color = Intensivity.getColor(z);        //Зная координаты можно высчитать цвет, используя уравнение мандельброта
                Dot dot = new Dot(i, j, COLOR.GREY, color); // создание новой точки, для каждой координаты
                pixels.add(dot);        //добавление точки в массив
            }
        }
    }

    public static void draw(PixelWriter pixelWriter, Pixels pixels){
        for(int i = 0; i < pixels.size(); i++){
            int intensiv = pixels.getIndex(i).getIntensivity();
            Color color = Color.rgb(intensiv, intensiv, intensiv);
            pixelWriter.setColor((int)pixels.getIndex(i).getX(), (int)pixels.getIndex(i).getY(), color);
        }

    }
}
