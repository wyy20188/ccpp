package com.wyy;


import com.wyy.Algorithm.IAlg;
import com.wyy.Algorithm.RandAlg;
import com.wyy.Element.Detector;
import com.wyy.Map.RoomMap;
import com.wyy.Tools.DebugTools;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        RoomMap roomMap=new RoomMap("E://CCPP/maze.txt");
        DebugTools.printRoomTrace(roomMap.getTheMap(),0);
        System.out.println();
        Detector det=new Detector(roomMap.getTheMap(),roomMap.getTheMap().get(1).get(2));
        IAlg alg=new RandAlg(det);
        Simulator simulator=new Simulator(roomMap,alg);
        simulator.runSim(2,1);
    }
}
