package com.wyy;

import com.wyy.Algorithm.IAlg;
import com.wyy.Algorithm.RandAlg;
import com.wyy.Element.Detector;
import com.wyy.Map.RoomMap;
import com.wyy.Tools.DebugTools;
import com.wyy.UI.UIControl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        RoomMap roomMap=new RoomMap("E://CCPP/maze2.txt");
        DebugTools.printRoomTrace(roomMap.getTheMap(),0);
        System.out.println();
        Detector det=new Detector(roomMap.getTheMap(),roomMap.getTheMap().get(1).get(2));
        IAlg alg=new RandAlg(det);
        Simulator simulator=new Simulator(roomMap,alg);
        simulator.runSim(2,1,50);

        ArrayList<Point> wall=new ArrayList<Point>();
        ArrayList<Point> obst=new ArrayList<Point>();
        ArrayList<Point> path=new ArrayList<Point>();

        //display
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                UIControl.Grid grid = new UIControl.Grid(40,30,15,500,wall,obst);
                JFrame window = new JFrame();
                window.setSize((grid.getWidthNum()+3)*grid.getCellSize(), (grid.getHeightNum()+1)*grid.getCellSize()+60);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(grid);
                window.setVisible(true);

                for (Point point: path) {
                    grid.fillCell(point.x,point.y);
                }
            }
        });
    }
}





//                    wall.add(new Point(0,0));
//                    wall.add(new Point(0,1));
//                    wall.add(new Point(0,2));
//                    wall.add(new Point(1,2));
//
//                    obst.add(new Point(3,3));
//                    obst.add(new Point(3,4));
//                    obst.add(new Point(4,3));
//                    obst.add(new Point(4,4));

//                    grid.fillCell(3, 5);
//                    grid.fillCell(6, 7);
//                    grid.fillCell(7, 7);
//                    grid.fillCell(8, 7);
//                    grid.fillCell(8, 8);
//                    grid.fillCell(0, 49);
//                    grid.fillCell(79, 49);
//                    grid.fillCell(39, 24);