import static java.lang.Math.sqrt;

public class Intensivity {
    private double coordX;
    private double coordY;


    public Intensivity(double x, double y){
        this.coordX = x;
        this.coordY = y;
    }

    public static Intensivity add(Intensivity a, Intensivity b){
        Intensivity add = new Intensivity(a.coordX + b.coordX, a.coordY + b.coordY);
        return add;
    }

    public static Intensivity mult(Intensivity a, Intensivity b){
        Intensivity mult = new Intensivity((a.coordX*b.coordX - a.coordY*b.coordY), (a.coordY*b.coordX + a.coordX*b.coordY));
        return mult;
    }

    public static double length(Intensivity a){
        double length = sqrt(a.coordX*a.coordX + a.coordY*a.coordY);
        return length;
    }

    public static int getColor(Intensivity a){
        Intensivity a1 = new Intensivity(a.coordX, a.coordY);
        for (int i = 255; i > 0 ; i--){
            if (length(a1) > 2 ){
                return i;               //возвращаем значение для rgb
            }
            a1 = add(mult(a1,a1), a);   //Считаем интенсивность для уравнения мандельброта
        }
        return 0;
    }

}
