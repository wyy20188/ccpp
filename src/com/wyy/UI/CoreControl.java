package com.wyy.UI;

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

        private int sleepTime=300;
        private int cellSize=15;
        private int widthNum=40;
        private int heightNum=50;

        public int getGridWidth() {
            return widthNum;
        }

        public void setGridWidth(int gridWidth) {
            this.widthNum = gridWidth;
        }

        public int getGridHeight() {
            return heightNum;
        }

        public void setGridHeight(int gridHeight) {
            this.heightNum = gridHeight;
        }

        public Grid() {
            fillCells = new ArrayList<>(25);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Point fillCell : fillCells) {
                int cellX = cellSize + (fillCell.x * cellSize);
                int cellY = cellSize + (fillCell.y * cellSize);
                g.setColor(Color.RED);
                g.fillRect(cellX, cellY, cellSize, cellSize);
            }
            g.setColor(Color.BLACK);
            g.drawRect(cellSize, cellSize, widthNum*cellSize, heightNum*cellSize);

            for (int i = cellSize; i <= widthNum*cellSize; i += cellSize) {
                g.drawLine(i, cellSize, i, heightNum*cellSize+cellSize);
            }

            for (int i = cellSize; i <= heightNum*cellSize; i += cellSize) {
                g.drawLine(cellSize, i, widthNum*cellSize+cellSize, i);
            }
        }

        public void fillCell(int x, int y) {
            fillCells.add(new Point(x, y));
            try {
                Thread.sleep(sleepTime);
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
                window.setSize(grid.widthNum*grid.cellSize+40, grid.heightNum*grid.cellSize+60);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(grid);
                window.setVisible(true);
                grid.fillCell(0, 0);
                grid.fillCell(79, 0);
                grid.fillCell(0, 49);
                grid.fillCell(79, 49);
                grid.fillCell(39, 24);
            }
        });
    }
}