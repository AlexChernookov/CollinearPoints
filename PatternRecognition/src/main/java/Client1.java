import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by a178300 on 7/27/2017.
 */
public class Client1 {

    public static void main(String[] args) throws FileNotFoundException {
        final String sl = File.separator;
        final String RESOURCES_PATH = System.getProperty("user.dir") + sl + "PatternRecognition" + sl +"src" + sl + "main" + sl + "resources";
        String file = RESOURCES_PATH + sl+ "input6.txt";

        Scanner scanner =  new Scanner(new File(file));
        int n = scanner.nextInt();
        // read the n points from a file
        //In in = new In(args[0]);
        //int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
