import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private LineSegment[] segm;

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
                for (int k = j + 1; k < pSize; k++)
                    for (int l = k + 1; l < pSize; l++) {
                        Point p = cp[i];
                        Point q = cp[j];
                        Point r = cp[k];
                        Point s = cp[l];
                        double spq = p.slopeTo(q);
                        double spr = p.slopeTo(r);
                        double sps = p.slopeTo(s);
                        if (spq == spr && spq == sps) {
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