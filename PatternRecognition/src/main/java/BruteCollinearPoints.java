import java.util.Arrays;

public class BruteCollinearPoints {
    private LineSegment[] segs;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        return;
    }

    // the number of line segments
    public int numberOfSegments() {
        return segs.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return Arrays.copyOf(segs, numberOfSegments());
    }
}