import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;


/**
 * A dice set holds a collection of Die objects. All of the die objects have the
 * same number of sides.
 */
public class DiceSet {
    int sides; 
    int numberOfDice;
  
   private Die[] diceSet = null; 
   
    
    // TODO add fields

    /**
     * Creates a DiceSet containing the given number of dice, each with the
     * given number of sides. All die values start off as 1. Throws an
     * IllegalArgumentException if either less than two dice were provided
     * or if it is asked to make dice with less than 4 sides.
     */

    public DiceSet(int sidesOnEachDie,int numberOfDice) {
        sidesOnEachDie = sides;
        numberOfDice = numberOfDice;
        int values = 1;
        this.diceSet = new Die[numberOfDice];       
         //this is what happens when you create an object within a class. This is one dice in a dice set. 
        for (int i = 0; i < numberOfDice; i++) {
            diceSet[i] = new Die(sidesOnEachDie, values);
        }
    }
    public DiceSet(int sidesOnEachDie, int ...values) {
        if (values.length < 2) {
            throw new IllegalArgumentException("At least two dice required");
            
        }
        if (sidesOnEachDie < 4) {
            throw new IllegalArgumentException("Dice must have at least four sides");
        }
        this.diceSet = new Die[values.length]; 
        for (int i = 0; i < values.length; i++) {
            diceSet[i] = new Die(sidesOnEachDie, values[i]);
            if (values[i] > sidesOnEachDie) {
                throw new IllegalArgumentException("You can't roll something larger than the number of sides on the dice itself!");
            }
          

        }
       //check that values  

        // TODO
    }


    /**
     * Returns the descriptor of the dice set; for example "5d20" for a set with
     * five dice of 20 sides each; or "2d6" for a set of two six-sided dice.
     */
    public String descriptor() {

        return Integer.toString(numberOfDice) + "d" + Integer.toString(sides);
        // TODO
    }

    /**
     * Returns the sum of the values of each die in the set.
     */
    public int sum() {
        int diceSum = 0;
        for (int i= 0; i < diceSet.length; i++) {
            diceSum += diceSet[i].getValue();
        }

        return diceSum;
        // TODO
    }

    public void roll() {
        for (int i = 0; i < diceSet.length; i++) {

            diceSet[i].roll();

        }
    }


    /**
     * Rolls all the dice in the set.
     */
    public void rollAll() {
      return;
    }
    /**
     * Rolls the ith die, updating its value.
     */
    public int rollIndividual(int individualDie) {
        if (individualDie > -1 && individualDie < diceSet.length) {
            diceSet[individualDie].roll();
         } else {
             throw new IllegalArgumentException("Can't roll die because it doesn't exist");
         }
         return diceSet[individualDie].getValue();
        }
        
        // TODO

    /**
     * Returns the value of the ith die.
     */
    public int getIndividual(int individualDie) {
        int indValue;
        if (individualDie > -1 && individualDie < diceSet.length) {
            indValue = diceSet[individualDie].getValue();

        } else {
            throw new IllegalArgumentException("can't get individual value of die because the die you are trying to get the value for does not exist");
        }
        return indValue;
        // TODO
    }

    /**
     * Returns the values of each of the dice in a list.
     */
    public List<Object> values() {
        return Arrays.asList(values());
        // TODO
    }

    /**
     * Returns whether this dice set has the same distribution of values as
     * an other dice set. The two dice sets must have the same number of dice
     * and the same number of sides per dice, and there must be the same
     * number of each value in each set.
     */
    public boolean isIdenticalTo(DiceSet diceSet2) {
        boolean identical;
        if (diceSet.length == diceSet2.numberOfDice && sides == diceSet2.sides) { 
            identical = true;
        } else {
            identical = false;
        }
        return identical; 
        // TODO
    }

    /**
     * Returns a string representation in which each of the die strings are
     * joined without a separator, for example: "[2][5][2][3]".
     */
    @Override public String toString() {
        String result = "";
        for (int i = 0; i < diceSet.length; i++) {
            result += "[" + diceSet[i].getValue() + "]";
        }
        return result;
        // TODO
    }
}
