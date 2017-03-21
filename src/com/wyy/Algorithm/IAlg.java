package com.wyy.Algorithm;

import com.wyy.Element.Direction;

import java.util.ArrayList;

/**
 * Created by wyy on 2017/3/20.
 */
public interface IAlg {
     boolean setMap();
     Direction getNextDirection();
     ArrayList<Direction> getDirections();
}
