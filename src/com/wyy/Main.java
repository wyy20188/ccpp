package com.wyy;


import com.wyy.Algorithm.IAlg;
import com.wyy.Algorithm.RandAlg;
import com.wyy.Element.Detector;
import com.wyy.Map.RoomMap;
import com.wyy.Tools.DebugTools;
import com.wyy.UI.CoreControl;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        RoomMap roomMap=new RoomMap("E://CCPP/maze2.txt");
//        DebugTools.printRoomTrace(roomMap.getTheMap(),0);
//        System.out.println();
//        Detector det=new Detector(roomMap.getTheMap(),roomMap.getTheMap().get(1).get(2));
//        IAlg alg=new RandAlg(det);
//        Simulator simulator=new Simulator(roomMap,alg);
//        simulator.runSim(2,1,50);


//
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                }
//
//                CoreControl.Grid grid = new CoreControl.Grid();
//                JFrame window = new JFrame();
//                window.setSize(840, 560);
//                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                window.add(grid);
//                window.setVisible(true);
//                System.out.println("has set grid");
//                new Thread(){
//                    public void run() {
//                        grid.fillCell(0, 0);
////                        try {
////                            Thread.sleep(1000);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
////                        grid.fillCell(79, 0);
//                    }
//                }.run();
//
//                new Thread(){
//                    public void run() {
//                        try {
//                            Thread.sleep(800);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        grid.fillCell(79, 0);
//                    }
//                }.run();
//
////                grid.fillCell(0, 49);
////                grid.fillCell(79, 49);
////                grid.fillCell(39, 24);
////                grid.fillCell(39, 40);
//                System.out.println("has fill cell");
//            }
//        });
//

    }

}
