public class Dot {
    private double X;
    private double Y;
    int intensivity;

     Dot(double x, double y, int intensivity){
        this.X = x;
        this.Y = y;
        //this.color = color;
        this.intensivity = intensivity;
    }

    double getX(){
        return  X;
    }
    double getY(){
        return Y;
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
/*
    void setColor(COLOR color){
        this.color = color;
    }*/

}
