/*@author uyen*/
package dicegame;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int numberOfRoll; //User decides number of dices to roll
        int userPoint;//User guess points.
        int dicePoint;//total of points of dices;
        int i=0;//count to stop loop
        int totalPlay=1;//Number of times user have played.
        int totalWin=0;//Number of times user win.
        float percentageWin;//winning percentage
        //loop until user don't want to play again.
        do{
            System.out.println("Wellcome to Dice Game!(1 for One dice, 2 for Two dices and 3 for Three dices)");
            // User chooses the number of roll
            System.out.println("How many dices would you like to roll?");
            numberOfRoll = input.nextInt();
            Dice myDice = new Dice(numberOfRoll);
            myDice.roll();
            dicePoint=myDice.getTotalPoints();
            System.out.printf("Total points of dices are: %d\n",dicePoint);
            //User guesses points
            System.out.println("User guess points: ");
            userPoint=input.nextInt();
            //Check if user guess right.         
            if(userPoint==dicePoint){
                totalWin++;
                System.out.println("You win!");
                System.out.printf("Total points of dices are: %d\n",dicePoint);
            }
            else{
                System.out.println("You loose!");
                System.out.printf("Total points of dices are: %d\n",dicePoint);
            }
            
            System.out.println("Would you like to play again? Y/N");
            String answer=input.next();
            String upperCaseAnswer=answer.toUpperCase();
            if(upperCaseAnswer.equals("Y")){
                i++;
                totalPlay++;
            }
            else
                i=0;
                
        }while(i!=0);
        //Print out history game and winning percentage
        percentageWin = (float)((totalWin*100)/totalPlay);
        System.out.printf("%nYou've played %d times.%n",totalPlay);
        System.out.printf("You've won %d times.",totalWin);
        System.out.printf("\nYour winning percentage is %s.%n",percentageWin+"%");
        System.out.println("Goodbye!");
    }
}
