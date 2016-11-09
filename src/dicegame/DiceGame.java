/*@author uyen*/
package dicegame;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        System.out.println("Wellcome to Dice Game!");
        Dice myDice=new Dice();
        myDice.playGame();
        myDice.history();
    }
}
