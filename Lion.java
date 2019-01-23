/*@version 1.0                              [ Lab#2: Critters ]
 *                                          *******CS 140******
 *                   Creators: @author Nick Williams, @author Mike Waters,& @author Jordan Adam
 *                                        Instructor: Ryan Parsons
 *                                            -> 1/23/2019 <-
 *                      -Lion Class defines state and behavior for Lions in simulation
 *
 *
 * */
import java.awt.*;
public class Lion extends Critter {
    // Fields belonging to Lion
    private int count;
    private Color initColor;

    // Constructs new Lion
    public Lion() {
        this.count = 0;
    }

    // Determines the color of Lions in the simulation
    // @return randomColor if still within 3 moves. else, returns the initial color value
    public Color getColor() {
        this.count = this.count + 1;
        if ((this.count - 1) % 3 == 0) {
            Color randomColor = getRandomColor();
            this.initColor = randomColor;
            return randomColor;
        } else {
            return this.initColor;
        }

    }
    // Determines the Actions taken by Lions for each step in the simulation
    // @param CritterInfo Interface containing directional state definitions for critters
    // @return Infect if other creature is in front, Left if Wall in front or Wall on right,
    // Right if creature in front is a Lion, Else hop.
    public Action getMove(CritterInfo info) {

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }

    }
    // Determines color (R,G,B) for lion for 3 steps of the simulation
    // @returns BLUE if number is less than 10/3, RED if number is > 20 / 3, else GREEN
    private Color getRandomColor() {
        double number = Math.random() * 10;
        if (number < (10/3)) {
            return Color.BLUE;
        } else if (number > (20/3)) {
            return Color.RED;
        } else {
            return Color.GREEN;
        }

    }

    // Represents the visual representation of Lion in simulation
    // @returns the string "L"
    public String toString() {
        return "L";
    }

}