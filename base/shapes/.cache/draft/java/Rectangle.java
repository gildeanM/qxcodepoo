public class Rectangle implements Shape{

    public String name = "Rect";
    public Point2D p1;
    public Point2D p2;

    public Rectangle(Point2D p1, Point2D p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString(){
        return String.format("Rect: P1=%s P2=%s", p1, p2);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getArea() {
        Double l = Math.abs(p1.x - p2.x);
        Double a = Math.abs(p1.y - p2.y);
        return l*a;
    }

    @Override
    public Double getPerimeter() {
        Double l = Math.abs(p1.x - p2.x);
        Double a = Math.abs(p1.y - p2.y);
        return 2*(l+a);
    }

    @Override
    public boolean inside(Point2D point) {
        return false;
    }
}
