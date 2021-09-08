/**
 * Axis-aligned rectangle abstraction.
 */
public class Rectangle {

    private final double xx;
    private final double yy;
    private final double width;
    private final double height;

    /**
     * Constructor.
     *
     * @param xx     the center x-coordinate
     * @param yy     the center y-coordinate
     * @param width  the width
     * @param height the height
     */
    public Rectangle(double xx, double yy, double width, double height) {
        this.xx = xx;
        this.yy = yy;
        this.width = width;
        this.height = height;
    }

    /**
     * Computer the area of the rectangle.
     *
     * @return the area
     */
    public double area() {
        // TODO: Completar
        return this.width * this.height;
    }

    /**
     * Computes the perimeter of the rectangle.
     *
     * @return the perimeter
     */
    public double perimeter() {
        // TODO: Completar
        return 2 * this.width + 2 * this.height;
    }

    /**
     * Checks if the argument intersects with this rectangle.
     *
     * @param b the other rectangle
     * @return true if there is intersection, false otherwise
     */
    public boolean intersects(Rectangle b) {
        // TODO: Completar
        double x1e = this.xx - (this.width / 2);
        double x1d = this.xx + (this.width / 2);
        double y1c = this.yy + (this.height / 2);
        double y1b = this.yy - (this.height / 2);

        double x2e = b.xx - (b.width / 2);
        double x2d = b.xx + (b.width / 2);
        double y2c = b.yy + (b.height / 2);
        double y2b = b.yy - (b.height / 2);

        return x1e < x2d && x1d > x2e && y1b < y2c && y1c > y2b;

    }

    /**
     * Check if the argument is inside this rectangle.
     *
     * @param b the other rectangle
     * @return true if it is contained, false otherwise
     */
    public boolean contains(Rectangle b) {

        // TODO: Completar
        double x1e = this.xx - (this.width / 2);
        double x1d = this.xx + (this.width / 2);
        double y1c = this.yy + (this.height / 2);
        double y1b = this.yy - (this.height / 2);

        double x2e = b.xx - (b.width / 2);
        double x2d = b.xx + (b.width / 2);
        double y2c = b.yy + (b.height / 2);
        double y2b = b.yy - (b.height / 2);

        return x2e > x1e && x2d < x1d && y2c < y1c && y2b > y1b || b.width == this.width;
    }

    public double getXx() {
        return xx;
    }

    public double getYy() {
        return yy;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle{"
            + "x=" + xx
            + ", y=" + yy
            + ", width=" + width
            + ", height=" + height
            + '}';
    }
}
