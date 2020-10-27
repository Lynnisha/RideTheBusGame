package com.codingwithnish;

public class Card {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
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
    }
}
