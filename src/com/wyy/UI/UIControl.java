package com.wyy.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
public class UIControl {

    public static class Grid extends JPanel {

        private List<Point> pathCells;
        private List<Point> wallCells;
        private List<Point> obstacleCells;

        private int sleepTime=300;
        private int cellSize=15;
        private int widthNum=40;
        private int heightNum=50;

        public int getCellSize() {
            return cellSize;
        }

        public int getWidthNum() {
            return widthNum;
        }

        public int getHeightNum() {
            return heightNum;
        }

        public Grid(int width,int height, int size, int sleep, ArrayList<Point> walls,ArrayList<Point> obstacles){
            widthNum=width;
            heightNum=height;
            cellSize=size;
            sleepTime=sleep;
            wallCells=walls;
            obstacleCells=obstacles;
            pathCells=new ArrayList<>();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Point fillCell : pathCells) {
                int cellX = cellSize + (fillCell.x * cellSize);
                int cellY = cellSize + (fillCell.y * cellSize);
                g.setColor(Color.ORANGE);
                g.fillRect(cellX, cellY, cellSize, cellSize);
            }

            for (Point fillCell : wallCells) {
                int cellX = cellSize + (fillCell.x * cellSize);
                int cellY = cellSize + (fillCell.y * cellSize);
                g.setColor(Color.BLACK);
                g.fillRect(cellX, cellY, cellSize, cellSize);
            }

            for (Point fillCell : obstacleCells) {
                int cellX = cellSize + (fillCell.x * cellSize);
                int cellY = cellSize + (fillCell.y * cellSize);
                g.setColor(Color.BLUE);
                g.fillRect(cellX, cellY, cellSize, cellSize);
            }
            // draw grid line
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
            pathCells.add(new Point(x, y));
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
            paintImmediately(this.getBounds());
        }
    }
}