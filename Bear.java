/*@version 1.0                              [ Lab#2: Critters ]
 *                                          *******CS 140******
 *                   Creators: @author Nick Williams, @author Mike Waters,& @author Jordan Adam
 *                                        Instructor: Ryan Parsons
 *                                            -> 1/23/2019 <-
 *                      -Bear Class defines state and behavior for Bears in simulation
 *
 *
 * */
import java.awt.*;

public class Bear extends Critter {

    // Fields belonging to all bears
    private int counter;
    private boolean polar;

    // Constructs a bear
    // @param the boolean value for color of bears
    public Bear(boolean polar){
        this.counter = 0;
        this.polar = polar;
    }
    // Determines the visual representation of Bears in simulation
    // @returns "/" if counter % 2 is == to 1, else "\"
    public String toString(){
        this.counter = this.counter + 1;
        if (counter % 2 == 1){
            return "/";
        } else {
            return "\\";
        }
    }
    // Determines Actions taken by Bears in simulation
    // @param CritterInfo Interface containing directional state definitions for critters
    // @return INFECT if creature in front is not a Bear, HOP if there is nothing in front,
    // else, LEFT.
    public Action getMove(CritterInfo info){
        // always infect if a neighbor is in front
        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    // Determines color of bear in simulation
    // @return WHITE if polar is true. Else Black.
    public Color getColor(){
        if (polar){
            return Color.white;
        } else {
            return Color.black;
        }
    }

}
