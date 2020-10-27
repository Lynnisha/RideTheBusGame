package com.codingwithnish;

import java.util.Scanner;

public class Main {


    //

    public static void main(String[] args) {
	// Create Scanner to take name.  Print welcome message
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = input.nextLine();
        System.out.println("Hello, " + name + "! Welcome to 'Ride the Bus'!");
        System.out.println("We will deal 5 cards, you must guess if they're higher or lower, black or red!");
        System.out.println("Guess all 5 cards correctly to win!");
        //display 1st card and ask to guess if the next card will be higher & lower
        System.out.println("The starting card is " +  ".  Is the next card 'higher' or 'lower'?");
        String valueGuess = input.nextLine();

        //compare user's guess to card #2.  If incorrect, start over. If correct, show card #2 & ask to guess color of card 3.

        //Compare color to card #3.  If correct, give value of card #3 & print message  asking if card #4 is 'higher or lower'

        //If value is correct, display card #4 & message they are correct ask if card #5 is 'black or red'?

        //If color is correct, display value for card #5 and print message saying they won the game!

    }
}
