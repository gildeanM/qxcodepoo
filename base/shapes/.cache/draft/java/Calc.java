public class Calc {

    public static Double distance(Point2D a, Point2D b){
        Double d = Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
        return d;
    }

}
