public class Point2D {

    public Double x;
    public Double y;

    public Point2D(Double x, Double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("(%.2f, %.2f)", x, y);
    }


}
