import java.util.Random;
import java.util.Scanner;
public class CrapsGame {
    public static void main(String[] args) {
        //Intilize variables
        boolean endGame = false;
        boolean done = false;
        Random Randomizer = new Random();
        String input = "";

        do{
            // First roll
            int dice1 = Randomizer.nextInt(1, 6)+1;
            int dice2 = Randomizer.nextInt(1, 6)+1;
            int sum = dice1 + dice2;
            int point;
            System.out.println("Die 1 = " + dice1);
            System.out.println("Die 2 = " + dice2);

            if (sum == 7 || sum == 11) {
                System.out.println("You rolled " + sum + " you Win   :)");
                endGame = true;
            } else if (sum == 2 || sum == 12 || sum == 3){
                System.out.println("You rolled " +sum +" You Crapped Out :(" );
                endGame = true;
            } else{ // Player must move to 2 + roll
                point = sum; // sets the point to be check the sum of the dice agaist second+ roll.
                System.out.println("You are aiming for a "+ point);
                do { // 2+ roll
                    dice1 = Randomizer.nextInt(1, 6)+1;
                    dice2 = Randomizer.nextInt(1, 6)+1;
                    sum = dice1 + dice2;
                    System.out.println("Die 1 = " + dice1);
                    System.out.println("Die 2 = " + dice2);
                    if(sum == point){
                        System.out.println("You matched You win!! :)");
                        endGame = true;
                    } else if(sum == 7 || sum == 11){
                        System.out.println("You rolled " + sum + " You Crapped out :(");
                        endGame = true;
                    } else { // Player did not Crap out or win
                        point = sum;
                        System.out.println("You are aiming for a " + point);
                    }
                } while(!endGame);
            }
            Scanner in = new Scanner(System.in);
            do {
                System.out.print("Do you want to continue [Y/N] ");
                input = in.nextLine();
                if(input.equalsIgnoreCase("n")){
                    done = true;
                }if(input.equalsIgnoreCase("y")){
                    done = true;
                    endGame = false;
                }
            } while (!done);
        } while(!endGame);
    }
}