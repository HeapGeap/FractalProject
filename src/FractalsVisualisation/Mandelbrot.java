package FractalsVisualisation;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.awt.*;

public class Mandelbrot extends JPanel {


    public void paint(Graphics g){
      super.paintComponents(g);
      g.setColor(Color.CYAN);
      paintSet(g,-2,1,-1.2,1.2);
      repaint();
  }



    private void paintSet(Graphics g, double reMin, double reMax, double imMin, double imMax) {
        double precision = Math.max((reMax - reMin) / 600, (imMax - imMin) / 600);
        int convergenceSteps = 20;
        for (double c = reMin, xR = 0; xR < 600; c = c + precision, xR++) {
            for (double ci = imMin, yR = 0; yR < 600; ci = ci + precision, yR++) {
                double convergenceValue = checkConvergence(ci, c, convergenceSteps);
                double t1 = (double) convergenceValue / convergenceSteps;
                double c1 = Math.min(255 * 2 * t1, 255);
                double c2 = Math.max(255 * (2 * t1 - 1), 0);

                if (convergenceValue != convergenceSteps) {
                    g.setColor(new Color(0x000000));
                } else {
                    g.setColor(Color.cyan); // Convergence Color
                }
                g.fillRect((int) xR, (int)yR, 1, 1);
            }
        }
    }

    private int checkConvergence(double ci, double c, int convergenceSteps) {
        double z = 0;
        double zi = 0;

        for (int i = 0; i < convergenceSteps; i++) {
            double ziT = 2 * (z * zi);
            double zT = z * z - (zi * zi);
            z = zT + c;
            zi = ziT + ci;

            if (z * z + zi * zi >= 4.0) {
                return i;
            }
        }
        return convergenceSteps;
    }
}