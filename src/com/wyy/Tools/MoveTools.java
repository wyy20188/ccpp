package com.wyy.Tools;

import com.wyy.Element.Cell;
import com.wyy.Element.Direction;
import com.wyy.Element.Global;

import java.util.Vector;

/**
 * Created by wyy on 2017/3/23.
 * provide some tools here
 */
public final class MoveTools {

    /**
     * @param map the map be detected
     * @param cell current cell
     * @param dir forward direction
     * @return how many spare steps can be found
     */
    public static int detectDist(Vector<Vector<Cell>> map, Cell cell, Direction dir){
        int dist=0;
        int posX,posY;
        char type;
        switch (dir){
            case BACK:
                posY=cell.getPosY()+1;
                type=map.get(posY).get(cell.getPosX()).getType();
                while (posY<map.size()&&(type!='w'&&type!='o')){
                    dist++;
                    posY++;
                    type=map.get(posY).get(cell.getPosX()).getType();
                }
                break;
            case FRONT:
                posY=cell.getPosY()-1;
                type=map.get(posY).get(cell.getPosX()).getType();
                while (posY>-1&&(type!='w'&&type!='o')){
                    dist++;
                    posY--;
                    type=map.get(posY).get(cell.getPosX()).getType();
                }
                break;
            case RIGHT:
                posX=cell.getPosX()+1;
                type=map.get(cell.getPosY()).get(posX).getType();
                while (posX<map.get(0).size()&&(type!='w'&&type!='o')){
                    dist++;
                    posX++;
                    type=map.get(cell.getPosY()).get(posX).getType();
                }
                break;
            case LEFT:
                posX=cell.getPosX()-1;
                type=map.get(cell.getPosY()).get(posX).getType();
                while (posX>-1&&(type!='w'&&type!='o')){
                    dist++;
                    posX--;
                    type=map.get(cell.getPosY()).get(posX).getType();
                }
                break;
            //// STOPSHIP: 2017/4/11
            case FL:
//                posX=cell.getPosX()-1;
//                posY=cell.getPosY()-1;
                System.out.println("wait for next version");
                break;
            case FR:
                System.out.println("wait for next version");
                break;
            case BL:
                System.out.println("wait for next version");
                break;
            case BR:
                System.out.println("wait for next version");
                break;
        }
        return dist;
    }

    //this method will change the status of cells
    //It is highly recommended to use detectDist() first to avoid some faults

    /**
     * This method will change the status of cells
     * It is highly recommended to use detectDist() first to avoid some faults
     * @param map the map be detected
     * @param cell current cell
     * @param dir forward direction
     * @param num the number of steps we shall go
     * @param sweep if true, assume the cell is cleaned
     * @return if true, the current cell; if false, null
     */
    public static Cell moveSteps(Vector<Vector<Cell>> map, Cell cell, Direction dir, int num, boolean sweep){
        Cell result=null;
        int x=cell.getPosX();
        int y=cell.getPosY();
        if(dir==Direction.FRONT){
            if(sweep)
                for(int i=1;i<num+1;i++){
                    map.get(y-i).get(x).setHasBeenCleaned(true);
                    map.get(y-i).get(x).setPassedTimes(map.get(y-i).get(x).getPassedTimes()+1);
                }
            result=map.get(y-num).get(x);
            result.setAttr(Global.BACK);
        }else if(dir==Direction.BACK){
            if(sweep)
                for(int i=1;i<num+1;i++){
                    map.get(y+i).get(x).setHasBeenCleaned(true);
                    map.get(y+i).get(x).setPassedTimes(map.get(y+i).get(x).getPassedTimes()+1);
                }
            result=map.get(y+num).get(x);
            result.setAttr(Global.FRONT);
        }else if(dir==Direction.LEFT){
            if(sweep)
                for(int i=1;i<num+1;i++){
                    map.get(y).get(x-i).setHasBeenCleaned(true);
                    map.get(y).get(x-i).setPassedTimes(map.get(y).get(x-i).getPassedTimes()+1);
                }
            result=map.get(y).get(x-num);
            result.setAttr(Global.RIGHT);
        }else if(dir==Direction.RIGHT){
            if(sweep)
                for(int i=1;i<num+1;i++){
                    map.get(y).get(x+i).setHasBeenCleaned(true);
                    map.get(y).get(x+i).setPassedTimes(map.get(y).get(x+i).getPassedTimes()+1);
                }
            result=map.get(y).get(x+num);
            result.setAttr(Global.LEFT);
        }
        return result;
    }
}










