/*@version 1.0                              [ Lab#2: Critters ]
 *                                          *******CS 140******
 *                   Creators: @author Nick Williams, @author Mike Waters,& @author Jordan Adam
 *                                        Instructor: Ryan Parsons
 *                                            -> 1/23/2019 <-
 *                             -Orca Class adds our orca creature to simulation
 *
 *
 * */

import java.awt.*;
public class Orca extends Critter {
    private int counter;
    private Color currentColor;

    public Orca(){
        counter = 1;
        currentColor = new Color(255,0,0);
    }

    //Depending on the the value of the switches the appearance of Orcas
    //@return Returns one of two possible looks for orca
    public String toString(){
        this.counter = this.counter + 1;
        if (counter % 2 == 0){
            return "><>";
        } else {
            return "<<>";
        }
    }

    //Determines the Actions taken by orcas for each step in the simulation
    //@param CritterInfo Interface containing directional state definitions for critters
    //@returns Actions for orcas dependant upon conditional statements.
    public Action getMove(CritterInfo info){
        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }else if (info.getLeft() == Neighbor.SAME && info.getRight() == Neighbor.SAME
                && info.getBack() == Neighbor.SAME) {
            return Action.HOP;
        } else if (info.getLeft() == Neighbor.SAME || info.getRight() == Neighbor.SAME
                &&  info.getFront() == Neighbor.SAME || info.getBack() == Neighbor.SAME) {
            if (info.getLeft() == Neighbor.OTHER) {
                return Action.LEFT;
            } else if (info.getRight() == Neighbor.OTHER) {
                return Action.RIGHT;
            } else if (info.getLeft() == Neighbor.WALL || info.getLeft() == Neighbor.SAME) {
                return Action.RIGHT;
            } else if (info.getRight() == Neighbor.WALL || info.getRight() == Neighbor.SAME) {
                return Action.LEFT;
            } else if (Math.random() > 0.5) {
                return  Action.HOP;
            } else {
                return Action.RIGHT;
            }
        } else {
            if (info.getLeft() == Neighbor.OTHER) {
                return Action.LEFT;
            } else if (info.getFront() == Neighbor.EMPTY) {
                return Action.HOP;
            } else {
                if (info.getLeft() == Neighbor.WALL) {
                    return Action.RIGHT;
                } else if (info.getRight() == Neighbor.WALL) {
                    return Action.LEFT;
                }
            }
        }
        return Action.LEFT;
    }

    //Determines color of Orcas dependant upon counter values
    //@return Current color of Orcas
    public Color getColor() {
        if (counter % 14 == 1) {
            currentColor = new Color(255,0,0);
        } else if (counter % 14 == 2) {
            currentColor = new Color(255,64,0);
        } else if (counter % 14 == 3) {
            currentColor = new Color(255,128,0);
        } else if (counter % 14 == 4) {
            currentColor = new Color(255,192,0);
        } else if (counter % 14 == 5) {
            currentColor = new Color(255,255,0);
        } else if (counter % 14 == 6) {
            currentColor = new Color(128,255,0);
        } else if (counter % 14 == 7) {
            currentColor = new Color(0,255,0) ;
        } else if (counter % 14 == 8) {
            currentColor = new Color(0,255,128) ;
        } else if (counter % 14 == 9) {
            currentColor = new Color(0,255,255);
        } else if (counter % 14 == 10) {
            currentColor = new Color(0,128,255);
        } else if (counter % 14 == 11) {
            currentColor = new Color(0,0,255);
        } else if (counter % 14 == 12) {
            currentColor = new Color(128,0,255);
        } else if (counter % 14 == 13) {
            currentColor = new Color(255,0,255);
        } else if (counter % 14 == 0) {
            currentColor = new Color(255,0,128);
        }
        counter++;
        return currentColor;
    }
}
