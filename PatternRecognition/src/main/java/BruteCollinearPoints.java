import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private final LineSegment[] segm;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        checkDuplicatePoints(points);
        List<LineSegment> lst = new ArrayList<>();

        Point[] cp = points.clone();
        Arrays.sort(cp);
        int pSize = points.length;
        for (int i = 0; i < pSize; i++)
            for (int j = i + 1; j < pSize; j++)
                for (int h = j + 1; h < pSize; h++)
                    for (int k = h + 1; k < pSize; k++) {
                        Point p = cp[i];
                        Point q = cp[j];
                        Point r = cp[h];
                        Point s = cp[k];
                        double spq = p.slopeTo(q);
                        double spr = p.slopeTo(r);
                        double sps = p.slopeTo(s);
                        if (Double.compare(spq, spr) == 0 && Double.compare(spq, sps) == 0) {
                            lst.add(new LineSegment(p, s));
                        }
                    }
        segm = lst.toArray(new LineSegment[lst.size()]);
    }

    private void checkDuplicatePoints(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicated points were found");
                }
            }
        }
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