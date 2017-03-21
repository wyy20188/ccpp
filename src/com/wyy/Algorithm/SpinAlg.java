package com.wyy.Algorithm;

import com.wyy.Element.Detector;
import com.wyy.Element.Direction;

import java.util.ArrayList;

/**
 * Created by wyy on 2017/3/21.
 * this class implements a basic algorithm spanning inner algorithm
 */
public class SpinAlg implements IAlg {
    Detector detector=new Detector();
    @Override
    public boolean setMap() {
        return false;
    }

    @Override
    public Direction getNextDirection() {
        return null;
    }

    @Override
    public ArrayList<Direction> getDirections() {
        return null;
    }
}
