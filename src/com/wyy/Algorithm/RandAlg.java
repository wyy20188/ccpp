package com.wyy.Algorithm;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.wyy.Element.Action;
import com.wyy.Element.Detector;
import com.wyy.Element.Direction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by wyy on 2017/3/21.
 * This is random algorithm, it was used for compare
 */
public class RandAlg extends IAlg {
    private Action action=new Action();

    public RandAlg(Detector myDet) {
        super(myDet);
    }


    @Override
    public Action getNextAction() {
        Random rand=new Random(System.currentTimeMillis());
//        int counter=0;
        ArrayList<Integer> numList=new ArrayList<>();
        numList.add(0);
        numList.add(1);
        numList.add(2);
        numList.add(3);
        while(true){
            if(numList.size()==0){
                return null;
            }
            int num1=rand.nextInt(numList.size());
            int num=numList.get(num1);
            numList.remove(num1);
            Direction dir;
            if(num==0)
                dir=Direction.FRONT;
            else if(num==1)
                dir=Direction.RIGHT;
            else if(num==2)
                dir=Direction.BACK;
            else
                dir=Direction.LEFT;

            if (myDet.space.get(dir)>0){
                action.direction=dir;
                num=rand.nextInt(myDet.space.get(dir));
                if(num==0)
                    action.steps=1;
                else
                    action.steps=num;
                return action;
            }
        }
    }

    @Override
    public Action getNextAction(Detector det) {
        myDet=det;
        return getNextAction();
    }
}
