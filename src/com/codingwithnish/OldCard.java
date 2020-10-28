package com.codingwithnish;

import java.util.ArrayList;
import java.util.List;

/*public class OldCard {
    private int value;
    private Suit suit;

    public OldCard(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardColor getColor() {
        if (suit == Suit.SPADES || suit == Suit.CLUBS) {
            return CardColor.BLACK;
        } else {
            return CardColor.RED;
        }
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }*/

    /*List<OldCard> cards = new ArrayList<>();
        cards.add(new OldCard(5, Suit.CLUBS));
                cards.add(new OldCard(6, Suit.CLUBS));
                cards.add(new OldCard(5, Suit.CLUBS));
                cards.add(new OldCard(6, Suit.CLUBS));
                cards.add(new OldCard(5, Suit.CLUBS));

                // Create Scanner to take name.  Print welcome message
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter your name:");
                String name = input.nextLine();
                System.out.println("Hello, " + name + "! Welcome to 'Ride the Bus'!");
                System.out.println("We will deal 5 cards, you must guess if they're higher or lower, black or red!");
                System.out.println("Guess all 5 cards correctly to win!");
                //display 1st card and ask to guess if the next card will be higher & lower
                for (int i = 0; i < 4; i++) {
        OldCard currentCard = cards.get(i);
        OldCard nextCard = cards.get(i + 1);
        //Question can change based on if 'i' as the value and alternate between the question
        System.out.println("The starting card is " + currentCard.toString() + ".  Is the next card 'higher' or 'lower'?");

        String guess = input.nextLine();

        if (guess.equals("higher") && nextCard.getValue() > currentCard.getValue() ||
        guess.equals("lower") && nextCard.getValue() < currentCard.getValue()) {
        System.out.println("Correct!  Card #2 was " + nextCard + ".");
        }else{
        System.out.println("Incorrect! Card #2 was " + nextCard + ". Try again!");
        System.exit(0);  //When exiting a process it's saying it's OK or 'normal'
        }
        }
        System.out.println("Congrats!  You've won!"); */

//compare user's guess to card #2.  If incorrect, start over. If correct, show card #2 & ask to guess color of card 3.

//Compare color to card #3.  If correct, give value of card #3 & print message  asking if card #4 is 'higher or lower'

//If value is correct, display card #4 & message they are correct ask if card #5 is 'black or red'?

//If color is correct, display value for card #5 and print message saying they won the game!