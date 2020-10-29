package com.codingwithnish;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your name:");
        String name = input.nextLine();
        System.out.println("Hello, " + name + "! Welcome to 'Ride the Bus'!");
        System.out.println("We will deal 5 cards, you must guess if they're higher or lower, black or red!");
        System.out.println("Guess all 5 cards correctly to win!");
        Card.runGame(name);
    }
}
