
enum COLOR{WHITE, BLACK, GREY}//Подумать над интенсивностью
public class Dot {
    private double X;
    private double Y;
    COLOR color;
    int intensivity;

     Dot(double x, double y, COLOR color, int intensivity){
        this.X = x;
        this.Y = y;
        this.color = color;
        this.intensivity = intensivity;
    }

    double getX(){
        return  X;
    }
    double getY(){
        return Y;
    }

    COLOR getColor(){
        return color;
    }

    int getIntensivity(){
         return intensivity;
    }

    void setX(double x){
        this.X = x;
    }

    void setY(double y){
        this.Y = y;
    }

    void setColor(COLOR color){
        this.color = color;
    }

}
