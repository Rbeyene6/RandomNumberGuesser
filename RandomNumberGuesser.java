/*
 * Class: CMSC203 
 * Instructor: Dr. Grigoriy Grinberg & Prof. Ashique Tanveer
 * Description: The program creates a driver class for the RNG class.
 * It generates a random number in the RNG class and asks the user to 
 * input their guess in the RandomNumberGuesser class.  It uses input 
 * validation to check if the input is correct and displays a message 
 * and the programmers name if the user guesses correctly.
 * 
 * Due: 6/28/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: _Rebecca Beyene_________
*/
import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int randNum, nextGuess, highGuess, lowGuess;
		String resp;
		char response = 0;
		System.out.println("The Random Number Guesser Game!");
		
		Scanner keyboard= new Scanner (System.in);
		
		RNG rng= new RNG();
		
		
		do {
		lowGuess=1;
		highGuess=100;
		randNum=RNG.rand();
		RNG.resetCount();
		System.out.println("Enter your first guess");
		
		nextGuess= keyboard.nextInt();
		
				
		do {
		
		
		if (nextGuess>randNum) {
			
			if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
	           {
	               if(nextGuess<=randNum && (randNum-nextGuess)<(randNum-lowGuess))
	               {
	                   lowGuess=nextGuess;
	                   
	               }
	               if(nextGuess>=randNum && (nextGuess-randNum)<(highGuess-randNum))
	               {
	                   highGuess=nextGuess;
	               }
	           }
			
		System.out.println("Number of guesses is "+rng.getCount());	
			
		System.out.println("Your guess is too high");
		
		highGuess=nextGuess;
								
		System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
		
		nextGuess= keyboard.nextInt();
		
		} else if (nextGuess<randNum) { 
		
			if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
	           {
	               if(nextGuess<=randNum && (randNum-nextGuess)<(randNum-lowGuess))
	               {
	                   lowGuess=nextGuess;
	               }
	               if(nextGuess>=randNum && (nextGuess-randNum)<(highGuess-randNum))
	               {
	                   highGuess=nextGuess;
	               }
	           }
			
		System.out.println("Number of guesses is "+rng.getCount());	
			
		System.out.println("Your guess is too low");
			
		lowGuess=nextGuess;
			
		System.out.println("Enter your next guess between "+lowGuess+" and "+highGuess);
		
		nextGuess= keyboard.nextInt();
		}
		}while (nextGuess!=(randNum));
		
		if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
        {
            if(nextGuess<=randNum && (randNum-nextGuess)<(randNum-lowGuess))
            {
                lowGuess=nextGuess;
            }
            if(nextGuess>=randNum && (nextGuess-randNum)<(highGuess-randNum))
            {
                highGuess=nextGuess;
            }
        }
		
		System.out.println("Number of guesses is "+rng.getCount());
		
		System.out.println("Congradulations, you guessed correctly \n Try again (y or n)");	
		
		resp=keyboard.next();
		
		response=resp.charAt(0);
		
		while (response != 'Y' && response != 'y' && response != 'N' && response != 'n')
        {	System.out.print("Please enter Yes or No: ");
			resp=keyboard.nextLine();
			response=resp.charAt(0);}
		
		}while (response=='Y' || response=='y');
		System.out.println("Thank you for playing...");
		System.out.println("Programmer: Rebecca Beyene");
		}

}

