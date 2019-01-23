/*@version 1.0                              [ Lab#2: Critters ]
 *                                          *******CS 140******
 *                   Creators: @author Nick Williams, @author Mike Waters,& @author Jordan Adam
 *                                        Instructor: Ryan Parsons
 *                                            -> 1/23/2019 <-
 *                      -Giant Class defines state and behavior for Giants in simulation
 *
 *
 * */

import java.awt.*;
public class Giant extends Critter {
    // Fields belonging to Giants
    private int counter;
    private String shout;

    // Constructs a Giant
    public Giant() {
        shout = "fee";
        counter =  0;
    }

    // Determines Actions taken by Giants in simulation
    // @param CritterInfo Interface containing directional state definitions for critters
    // @return INFECT if other creature is in front, If no one is in front HOP, else turn RIGHT.
    public Action getMove(CritterInfo info){
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    // Determines visual representation of Giants in simulation
    // @return "fie", "foe", "fum", "fee" dependant upon conditional tests.
    public String toString(){
        if (counter % 24 == 6) {
            shout = "fie";
        } else if (counter % 24 == 12) {
            shout = "foe";
        } else if (counter % 24 == 18) {
            shout = "fum";
        } else if (counter % 24 == 0) {
            shout = "fee";
        }
        counter++;
        return shout;
    }

    // Determines color of giants for each step of simulation
    // @return GRAY
    public Color getColor(){
        return Color.GRAY;
    }

}