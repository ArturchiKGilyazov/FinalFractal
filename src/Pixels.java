import java.util.Vector;

public class Pixels {
    Vector<Dot> pixels;
/*
    public Pixels(){
        pixels  =   V
    }
*/
    public Pixels() {
        pixels = new Vector<>();
    }
    public void add(Dot dot){
        this.pixels.add(dot);
    }

    public int size(){
        return this.pixels.size();
    }

    public Dot getIndex(int index){
        return pixels.get(index);
    }
    public void clear(){
        pixels.clear();
    }
}
