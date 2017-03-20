package com.wyy.Algorithm;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.wyy.Direction;

import java.util.ArrayList;

/**
 * Created by wyy on 2017/3/20.
 */
public interface PathAlgo {
     void setMap();
     Direction getNextDirection();
     ArrayList<Direction> getDirections();
}
