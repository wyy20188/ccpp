package com.wyy.Algorithm;

import com.wyy.Element.Action;
import com.wyy.Element.Detector;
import com.wyy.Element.Direction;

import java.util.ArrayList;

/**
 * Created by wyy on 2017/3/20.
 * new algorithm created by myself
 */
public class MyAlg extends IAlg{
    public MyAlg(Detector myDet) {
        super(myDet);
    }

    @Override
    public Action getNextAction() {
        return null;
    }

    @Override
    public Action getNextAction(Detector det) {
        this.myDet=det;
        return getNextAction();
    }


    //step1 select and go to one direction

    //step2 judge with old samples

    //step3 create new pattern (or use old one)
}
