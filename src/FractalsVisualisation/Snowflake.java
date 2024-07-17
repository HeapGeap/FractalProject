package FractalsVisualisation;

import javax.swing.*;
import java.awt.*;

public class Snowflake extends JPanel {

    Point a = new Point(50, 400);
    Point b = new Point(550, 400);
    Point a1 = new Point(300,50);
    Point b1 = new Point(50,400);
    Point a2 = new Point(550,400);
    Point b2 = new Point(300,50);

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        drawKochLine(g, a, b, 0, 3);
        drawKochLine(g, a1, b1, 2.2, 3);
        drawKochLine(g, a2, b2, 4.1, 3);

    }
    private void drawKochLine(Graphics g, Point a, Point b, double fi, int n) {

        if (n <= 0) {
            // рисуем прямую, если достигнута необходимая глубина рекурсии.
            g.drawLine(a.x, a.y, b.x, b.y);
        } else {
            // находим длину отрезка (a; b).
            double length = Math.pow(Math.pow(b.y - a.y, 2) + Math.pow(b.x - a.x, 2), 0.5);
            // находим длину 1/3 отрезка (a; b)
            double length1of3 = length / 3;

            // находим т., делящую отрезок как 1:3.
            Point a1 = new Point(a.x + (int) Math.round((length1of3 * Math.cos(fi))), a.y + (int) Math.round((length1of3 * Math.sin(fi))));

            // находим т., делящую отрезок как 2:3.
            Point b1 = new Point(a1.x + (int) Math.round((length1of3 * Math.cos(fi))), a1.y + (int) Math.round((length1of3 * Math.sin(fi))));

            // находим т., которая будет вершиной равностороннего
            // треугольника.
            Point c = new Point(a1.x + (int) Math.round((length1of3 * Math.cos(fi + Math.PI / 3))), a1.y + (int) Math.round((length1of3 * Math.sin(fi + Math.PI / 3))));

            n--;
            drawKochLine(g, a1, c, fi + Math.PI / 3, n);
            drawKochLine(g, c, b1, fi - Math.PI / 3, n);

            n--;
            drawKochLine(g, a, a1, fi, n);
            drawKochLine(g, b1, b, fi, n);
        }
    }
}


