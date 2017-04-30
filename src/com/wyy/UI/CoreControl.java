package com.wyy.UI;//package com.wyy.UI;
//
//import javax.swing.*;
//
///**
// * Created by wyy on 2017/4/30.
// */
//public class Board extends JPanel{
//    private void newDisplay(){
//
//    }
//}
//
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CoreControl {

    public static class Grid extends JPanel {

        private List<Point> fillCells;

        public Grid() {
            fillCells = new ArrayList<>(25);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Point fillCell : fillCells) {
                int cellX = 10 + (fillCell.x * 10);
                int cellY = 10 + (fillCell.y * 10);
                g.setColor(Color.RED);
                g.fillRect(cellX, cellY, 10, 10);
            }
            g.setColor(Color.BLACK);
            g.drawRect(10, 10, 800, 500);

            for (int i = 10; i <= 800; i += 10) {
                g.drawLine(i, 10, i, 510);
            }

            for (int i = 10; i <= 500; i += 10) {
                g.drawLine(10, i, 810, i);
            }
        }

        public void fillCell(int x, int y) {
            fillCells.add(new Point(x, y));
            System.out.println("point"+x+","+y);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
            paintImmediately(this.getBounds());
        }

    }

    public static void main(String[] a) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Grid grid = new Grid();
                JFrame window = new JFrame();
                window.setSize(840, 560);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(grid);
                window.setVisible(true);
                System.out.println("has set grid");
                grid.fillCell(0, 0);
                grid.fillCell(79, 0);
                grid.fillCell(0, 49);
                grid.fillCell(79, 49);
                grid.fillCell(39, 24);
                grid.fillCell(39, 40);
                System.out.println("has fill cell");
            }
        });
    }


}