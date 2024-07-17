package FractalsVisualisation;

import javax.swing.*;
import java.awt.*;

public class Dragon extends JPanel
{

    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.setColor(Color.magenta);
        drawDragon(170, 200, 400, 450, 17, g);//Задаём прямую и указываем количество итераций
        repaint();
    }

    private void drawDragon(int x1, int y1, int x2, int y2, int n, Graphics g)//Основная рекурсивная функция
    {
        int xn, yn;
        if(n > 0) //Пока n > 0 - продолжаем поворачивать прямые на 90 градусов и  уменьшать их размеры
        {
            xn = (x1 + x2) / 2 + (y2 - y1) / 2;
            yn = (y1 + y2) / 2 - (x2 - x1) / 2 ;
            drawDragon(x2, y2, xn, yn, n - 1, g);
            drawDragon(x1, y1, xn, yn, n - 1, g);
        }
        if(n == 0)//Приступаем к рисованию прямых
            g.drawLine(x1, y1, x2, y2);
        else if (n<0){
            return;
        }
    }

}
