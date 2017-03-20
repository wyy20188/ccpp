package com.wyy;

// suggest the coordination of (left,up) as (0,0)
class Cell {
    char type;// r room; o obstacle; g gate; w wall;
    int posX;
    int poxY;
    int passedTime;
    boolean hasBeenCleaned;
    int height;// optional
    int attr;// optional
}
