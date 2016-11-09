package dicegame;
import java.util.Random;
import java.util.Scanner;
public class Dice {
    Scanner input = new Scanner (System.in);
    private int numberOfDices; // number of dices that user decides to roll.
    private int numberOfThrows; // number of times that user roll the dices
    private int diceValue; // Current dice value
    private int totalPoint=0; // total value when dices throw bounces times.
    private int userPoint;//User guess points.
    int i=0;//count to stop loop
    private int average;
    private int totalPlay=1;//Number of times user have played.
    private int totalWin=0;//Number of times user win.
    private float percentageWin;//winning percentage
    
    //Constructor
    public Dice(int numDices, int numThrow)
    {
        numberOfDices=numDices;
        numberOfThrows=numThrow;
    }
    public Dice()
    {
    }
    
    // One dice with one throw
    // return a random number between 1-6
    public int OneDiceOneThrow()
    {
        diceValue = 1 + (int)(Math.random()*6);
        return diceValue;
    }
    
    // Multi dices with one throw
    public int MultiDicesOneThrow()
    {
        for(int i=0; i<numberOfDices; i++)
           totalPoint += OneDiceOneThrow();
        return totalPoint;
    }
    
    // Multi dices with multi throws
    public void Throw()
    {
        for(int i=0; i<numberOfThrows;i++)
            totalPoint += MultiDicesOneThrow();
        average = totalPoint/numberOfThrows;
    }
    
    public int getTotalPoints()
    {
        return totalPoint;
    }
    
    public int getAverage()
    {
        return average;
    }
    
    public void playGame()
    {
        do{
            // User chooses the number of dices to roll
            System.out.println("How many dices would you like to roll?");
            numberOfDices = input.nextInt();
            // User chooses times to throw the dices
            System.out.println("How many times would you like to throw the dices?");
            numberOfThrows = input.nextInt();
            
            Dice myDice = new Dice(numberOfDices,numberOfThrows);
            myDice.Throw();
            totalPoint=myDice.getTotalPoints();
            System.out.printf("Total points of %d dices with %d times throws are: %d\n",numberOfDices,numberOfThrows,totalPoint);
            
            //User guesses points
            System.out.println("User guess points: ");
            userPoint=input.nextInt();
            
            //Check whether user guesses right or wrong
            if(userPoint==totalPoint){
                totalWin++;
                System.out.println("You win!");
                System.out.printf("Total points of dices are: %d\n",totalPoint);
            }
            else{
                System.out.println("You loose!");
                System.out.printf("Total points of dices are: %d\n",totalPoint);
            }
            totalWin +=myDice.getTotalWin();
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
    }
    
    public int getTotalWin()
    {
        return totalWin;
    }
    
    public int getTotalPlay()
    {
        return totalPlay;
    }
    
    public void history()
    {
        //Print out history game and winning percentage
        percentageWin = (float)((getTotalWin()*100)/getTotalPlay());
        System.out.printf("%nYou've played %d times.%n",getTotalPlay());
        System.out.printf("You've won %d times.",getTotalWin());
        System.out.printf("\nYour winning percentage is %s.%n",percentageWin+"%");
        System.out.println("Goodbye!");
    }
}
