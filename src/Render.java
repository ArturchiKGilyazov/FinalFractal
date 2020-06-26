import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Render {


    public static void render(GraphicsContext gc, double startX, double startY ,double endX, double endY, Pixels pixels, double zoom){
       /*System.out.println(startX);
        System.out.println(startY);
        System.out.println(endX);
        System.out.println(endY);*/
        //System.out.println(endX-startX);
        //System.out.println(endY-startY);
       // pixels.clear();
        double width = 900;
        double heigth = 600;
        double length = 300;    //Длинна пиксельного единичного отрезка

        double step = 1 / zoom;
        //Потому что у нас координатная плоскость начинается не с левого верхнего угла, мы должны сдвигать её
        double rX = 2 * width / 3;
        double rY = heigth / 2;

        for(double i = startX; i < endX; i +=step){
            for (double j = startY; j < endY; j +=step){
                double x = (i - rX) / length;
                double y = (j - rY) / length;

                Intensivity z = new Intensivity(x, y);
                int color = Intensivity.getColor(z);        //Зная координаты можно высчитать цвет, используя уравнение мандельброта
                Dot dot = new Dot(i*zoom - startX*zoom, j*zoom - startY*zoom, color); // создание новой точки, для каждой координаты
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
