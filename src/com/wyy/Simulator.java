package com.wyy;

import com.wyy.Algorithm.IAlg;
import com.wyy.Element.Action;
import com.wyy.Element.Cell;
import com.wyy.Element.Detector;
import com.wyy.Map.RoomMap;
import com.wyy.Tools.DebugTools;
import com.wyy.Tools.MoveTools;

import java.util.Vector;

/**
 * Created by wyy on 2017/3/21.
 * this class is used to deal with the simulation
 * it needs an algorithm and a map as parameter
 * some testing data also should be made here
 * The simulator should make sure it can detect the problems first
 */
public class Simulator {
    private Vector<Vector<Cell>> usedMap;
    private IAlg usedAlg;

    public Simulator(RoomMap map, IAlg alg){
        usedMap=map.getTheMap();
        usedAlg=alg;
    }

    /**
     * two params define the initial cell
     * @param posX x coordinator
     * @param posY y coordinator
     * @param times the rounds the simulator can run, 0 means infinite
     */
    public void runSim(int posX, int posY,int times){
        //1. initial and judge if the point and operation is rational
        Cell curCell = usedMap.get(posY).get(posX);
        Detector dec = new Detector(usedMap, curCell);
        usedAlg.updateDetector(dec);
        curCell.setHasBeenCleaned(true);
        curCell.setPassedTimes(curCell.getPassedTimes()+1);
        Action nextAction;
        if(times<=0){
            times=Integer.MAX_VALUE;
        }
        while ((nextAction=usedAlg.getNextAction())!=null && (times-->0)){//null means alg is to end
            //test if the action is unreasonable first
            boolean flag=false;// true means collapse happened
            int steps=nextAction.steps;
            if(MoveTools.detectDist(usedMap, curCell,nextAction.direction)<steps){
                System.out.println("bong!");// hit a wall or obstacle
                // STOPSHIP: 2017/3/23
                return;
            }

            curCell =MoveTools.moveSteps(usedMap, curCell,nextAction.direction,steps,true);
            //debug
            //System.out.println("curPoint:" +curPoint.getPosX()+" ; "+curPoint.getPosY());
            if(curCell ==null){
                System.out.println("wrong");
            }
            //2. update the status of the robot and its detector
            assert curCell != null;
            dec.updatePos(curCell,curCell.getAttr());
            usedAlg.updateDetector(dec);

            System.out.println(nextAction.direction+":"+nextAction.steps);
            DebugTools.printRoomTrace(usedMap,1);
            System.out.println("-----------------------");
        }
        System.out.println("Simulation ends");
    }
    //a random point // STOPSHIP: 2017/3/21
    public void runSim(){

    }

}
















