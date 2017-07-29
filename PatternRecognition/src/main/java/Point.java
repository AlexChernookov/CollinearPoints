import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param x the <em>x</em>-coordinate of the point
     * @param y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     * point (x0 = x1 and y0 = y1);
     * a negative integer if this point is less than the argument
     * point; and a positive integer if this point is greater than the
     * argument point
     */
    public int compareTo(Point that) {
        validateObject(that);
        if (this.x == that.x && this.y == that.y) return 0;
        if (this.y < that.y || this.y == that.y && this.x < that.x) return -1;
        return 1;
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        validateObject(that);
        if (y == that.y) {
            if (x == that.x) {
                return Double.NEGATIVE_INFINITY;
            }
            return +0d;
        } else if (x == that.x) {
            return Double.POSITIVE_INFINITY;
        }
        return ((double) (that.y - y)) / (that.x - x);
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>() {

            @Override
            public int compare(Point p1, Point p2) {
                validateObject(p1);
                validateObject(p2);
                double p1Slope = slopeTo(p1);
                double p2Slope = slopeTo(p2);
                return Double.compare(p1Slope, p2Slope);
            }
        };
    }

    private void validateObject(Point p) {
        if (p == null) throw new java.lang.NullPointerException();
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        Point s = new Point(2, 2);
        p.slopeTo(s);
    }
}