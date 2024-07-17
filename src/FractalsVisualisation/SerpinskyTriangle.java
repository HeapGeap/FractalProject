package FractalsVisualisation;

import javax.swing.*;
import java.awt.*;

public class SerpinskyTriangle extends JPanel {

        private static final int PANEL_WIDTH =600, PANEL_HEIGHT = 600;
        private static final int TRI_WIDTH= 500, TRI_HEIGHT= 500;
        private static final int SIDE_GAP = (PANEL_WIDTH - TRI_WIDTH)/2;
        private static final int TOP_GAP = (PANEL_HEIGHT - TRI_HEIGHT)/2;
        private int countTriangles;

        Point top = new Point(PANEL_WIDTH/2, TOP_GAP);
        Point left = new Point(SIDE_GAP, TOP_GAP+ TRI_HEIGHT);
        Point right = new Point(SIDE_GAP + TRI_WIDTH, TOP_GAP+ TRI_HEIGHT);

        public void paint(Graphics g){
           super.paintComponents(g);
           drawTriangle(g,8,top,left,right);
           repaint();
        }

        private void drawTriangle(Graphics g, int levels, Point top, Point left, Point right) {

            if(levels < 0) {
                return ;
            }

            countTriangles++;

            g.setColor(Color.YELLOW);

            Polygon tri = new Polygon();
            tri.addPoint(top.x, top.y);  //use top,left right rather than fixed points
            tri.addPoint(left.x, left.y);
            tri.addPoint(right.x, right.y);
            g.drawPolygon(tri);

            // Get the midpoint on each edge in the triangle
            Point p12 = midpoint(top, left);
            Point p23 = midpoint(left, right);
            Point p31 = midpoint(right, top);

            // recurse on 3 triangular areas
            drawTriangle(g, levels - 1, top, p12, p31);
            drawTriangle(g, levels - 1, p12, left, p23);
            drawTriangle(g, levels - 1, p31, p23, right);
        }

        private Point midpoint(Point p1, Point p2) {
            return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        }

    }
