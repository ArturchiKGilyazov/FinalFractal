public class Mouse {
    private double x;
    private double y;
    private double zoom = 1;
    private double startX;
    private double previousStartX;
    private double startY;
    private double previousStartY;
    private double endX;
    private double previousEndX;
    private double endY;
    private double previousEndY;
    private double width;
    private double height;

    public Mouse(double width, double height){
        x = 0;
        y = 0;
        startX = 0;
        startY = 0;
        endX = width;
        endY = height;
        this.width = width;
        this.height = height;
    }

    public double getPreviousEndX() {
        return previousEndX;
    }

    public double getPreviousEndY() {
        return previousEndY;
    }

    public double getPreviousStartX() {
        return previousStartX;
    }

    public double getPreviousStartY() {
        return previousStartY;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x_) {
        this.x = x_;// + this.startX;
    }

    public void setY(double y_) {
        this.y = y_;// + this.startY;
    }

    public void getZooming(double degree){
        /*for (int i = 0; i < degree; i++){
            zoom *= 2;
        }*/
        System.out.println(this.zoom);
        this.zoom *= degree;
        //return zoom;
    }

    public double getZoom() {
        return zoom;
    }

    public void update(Mouse mouse){
        this.previousStartX = mouse.startX;
        this.previousStartY = mouse.startY;
        this.previousEndX = mouse.endX;
        this.previousEndY = mouse.endY;
        if((x < width/(2*mouse.zoom)) || (y < height/(2*zoom)) || (x + width/(2*zoom) > width) || (y + height/(2*zoom) > height)) {
            if(x < width/(2*zoom) || x + width/(2*zoom) > width)
            {
                if(x < width/(2*zoom))
                {
                    startX = 0;
                    endX = width/zoom;
                }
                if(x + width/(2*zoom) > width)
                {
                    startX = width/zoom;
                    endX = width;
                }
            }
            else
            {
                startX = x - width/(2*zoom);
                endX = x + width/(2*zoom);
            }

            if(y < height/(2*zoom) || y + height/(2*zoom) > height)
            {
                if(y - height/(2*zoom) < 0)
                {
                    startY = 0;
                    endY = height/(zoom);
                }
                if(y + height/(2*zoom) > height)
                {
                    startY = height/(zoom);
                    endY = height;
                }
            }
            else
            {
                startY = y - height/(2*zoom);
                endY = y + height/(2*zoom);
            }
        }
        else
        {
            startX = x - width/(2*zoom);
            endX = x  + width/(2*zoom);
            startY = y - height/(2*zoom);
            endY = y + height/(2*zoom);
        }
    }

}
