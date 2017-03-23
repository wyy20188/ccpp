package com.wyy.Algorithm;

import com.wyy.Element.Action;
import com.wyy.Element.Detector;
import com.wyy.Element.Direction;

import java.util.ArrayList;

/**
 * Created by wyy on 2017/3/21.
 * this class implements a basic algorithm spanning inner algorithm
 * We must make sure the Detector will be given to the algorithm
 */
public class SpinAlg extends IAlg {

    public SpinAlg(Detector myDet) {
        super(myDet);
    }

    @Override
    public Action getNextAction() {
        return null;
    }

    @Override
    public Action getNextAction(Detector det) {
        myDet=det;
        return getNextAction();
    }
}
