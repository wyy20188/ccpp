package com.wyy;

import com.wyy.Algorithm.IAlg;
import com.wyy.Element.Action;
import com.wyy.Element.Cell;
import com.wyy.Element.Detector;
import com.wyy.Element.Direction;
import com.wyy.Map.RoomMap;
import com.wyy.Tools.MoveTools;

import java.util.Vector;

/**
 * Created by wyy on 2017/3/21.
 * this class is used to deal with the simulation
 * it needs an algorithm and a map as parameter
 * some testing data also should be made here
 */
public class Simulator {
    Vector<Vector<Cell>> actualMap;
    IAlg actualAlg;
    Detector dec;
    Cell curPoint;

    public Simulator(RoomMap map, IAlg alg){
        actualMap=map.getTheMap();
        actualAlg=alg;
    }

    /**
     * two params define the initial cell
     * @param posX x coordinator
     * @param posY y coordinator
     */
    public void runSim(int posX, int posY){
        //1. initial and judge if the point and operation is rational
        Cell cell= actualMap.get(posY).get(posX);
        dec=new Detector(actualMap,cell);
        actualAlg.updateDetector(dec);
        Action nextAction;
        while ((nextAction=actualAlg.getNextAction())!=null){//null means alg is to end
            //test if the action is unreasonable first
            boolean flag=false;// true means collapse happened
            int steps=nextAction.steps;
            if(MoveTools.detectDist(actualMap,cell,nextAction.direction)>steps){
                System.out.println("bong!");// hit a wall or obstacle
                // STOPSHIP: 2017/3/23
                return;
            }
            cell.setHasBeenCleaned(true);
            cell.setPassedTimes(cell.getPassedTimes()+1);
            curPoint=MoveTools.moveSteps(actualMap,cell,nextAction.direction,steps);
            if(curPoint==null){
                System.out.println("wrong");
            }
            //2. update the status of the robot and its detector
            dec.updatePos(curPoint);
            actualAlg.updateDetector(dec);
        }

    }
    //a random point // STOPSHIP: 2017/3/21
    public void runSim(){

    }

}
















