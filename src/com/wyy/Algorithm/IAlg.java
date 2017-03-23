package com.wyy.Algorithm;

import com.wyy.Element.Action;
import com.wyy.Element.Detector;

import java.util.ArrayList;

/**
 * Created by wyy on 2017/3/20.
 * This interface defines some basic functions which should be implemented by a new algorithm,
 * since they are essential for the simulator to apply the program
 */
public abstract class IAlg {
    protected Detector myDet;

    public abstract Action getNextAction();
    public abstract Action getNextAction(Detector det);

    public IAlg(Detector myDet) {
        this.myDet = myDet;
    }
    public void updateDetector(Detector mydet){
        this.myDet=mydet;
    }

//    public abstract Action getNextAction();
//    public abstract IAlg(Detector detector);
}
