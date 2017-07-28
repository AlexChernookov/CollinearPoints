import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    private LineSegment[] segm;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        int pSize = points.length;
    }

    // the number of line segments
    public int numberOfSegments() {
        return segm.length;
    }
    // the line segments

    public LineSegment[] segments() {
        return segm.clone();
    }
}