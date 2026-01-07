public class Circle implements Shape{

    public String name = "Circ";
    public Point2D center;
    public Double radius;

    public Circle(Point2D center, Double radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String toString(){
        return String.format("Circ: C=%s, R=%.2f", center, radius);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public Double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public boolean inside(Point2D point) {
        return false;
    }
}
