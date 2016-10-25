/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 *
 * @author uyen
 */
public class Dice {
    private int numberOfRolls; // number of dices that user decides to roll.
    private int dice1, dice2, dice3;
    //Constructor
    public Dice(int num)
    {
        numberOfRolls = num;
    }
    public void roll()
    {
        dice1 = 1+(int)(Math.random()*6);
        dice2 = 1+(int)(Math.random()*6);
        dice3 = 1+(int)(Math.random()*6);
    }
    //Get the total of point of dices
    public int getTotalPoints()
    {
        if(numberOfRolls==1)
            return dice1;
        else if(numberOfRolls==2)
            return dice1+dice2;
        else
            return dice1+dice2+dice3;
    }
}
