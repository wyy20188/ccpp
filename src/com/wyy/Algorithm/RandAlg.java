package com.wyy.Algorithm;

import com.wyy.Element.Action;
import com.wyy.Element.Detector;
import com.wyy.Element.Direction;

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
        if (myDet.space.get(Direction.RIGHT)>0){
            action.direction=Direction.RIGHT;
            action.steps=1;
            return action;
        }
        return null;
    }

    @Override
    public Action getNextAction(Detector det) {
        myDet=det;
        return getNextAction();
    }
}
