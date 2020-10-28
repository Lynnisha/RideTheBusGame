package com.codingwithnish;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Card extends JFrame{

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    int value;
    String suit;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    String pic;

    public Card(int value, String suit)  {
        this.value = value;
        this.suit = suit;
        this.pic = pic;
    }




    public static Card dealOne(String id ){
        Card card = new Card(0,"");
        String json = "";
        try {
            json = readUrl("https://deckofcardsapi.com/api/deck/" + id + "/draw/?count=1");

        } catch (Exception e) {
            System.out.println("Couldn't read the URL");
        }

        //setting raw Json to defined JSON object
        JsonElement element = new JsonParser().parse(json);
        JsonObject object = element.getAsJsonObject();

        String value = object.get("cards").getAsJsonArray().get(0).getAsJsonObject().get("value").getAsString();
        String suit = object.get("cards").getAsJsonArray().get(0).getAsJsonObject().get("suit").getAsString();
        String pic = object.get("cards").getAsJsonArray().get(0).getAsJsonObject().get("image").getAsString();
        //String card = value + " of " + suit;


        //String remaining = object.get("remaining").getAsString();
        if (value.equals("JACK")) {
            card.setValue(11);
        } else if (value.equals("QUEEN")) {
            card.setValue(12);

        } else if (value.equals("KING")) {
            card.setValue(13);

        }else if (value.equals("ACE")) {
            card.setValue(14);

        } else {
            card.setValue(Integer.parseInt(value));
        }
        card.setSuit(suit);
        card.setPic(pic);

        return card;

    }
    public String shuffleDeck() {
        String json = "";
        try {
            json = readUrl("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
        } catch (Exception e) {
            System.out.println("Couldn't read the URL");
        }

        //setting raw Json to defined JSON object
        JsonElement element = new JsonParser().parse(json);
        JsonObject object = element.getAsJsonObject();

        String id = object.get("deck_id").getAsString();

        return id;

    }

    public static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        StringBuffer buffer;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

        } finally {
            if (reader != null)
                reader.close();
        }
        String returned = buffer.toString();
        return returned;

    }


    public void displayCard(String urlPath) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        Image image = null;
        URL url = null;
        try {
            url = new URL(urlPath);
            image = ImageIO.read(url);
        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL");
        } catch (IOException iox) {
            System.out.println("Can not load file");
        }
        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label, BorderLayout.CENTER);

        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);

    }
public static void runGame(String userName){
    String stringValue1;
    String stringValue2;
    String stringValue3;
    String stringValue4;
    String stringValue5;

    Card card1 = new Card(0, "");

    String cardID = card1.shuffleDeck();
    card1 = Card.dealOne(cardID);

    Card card2 = Card.dealOne(cardID);
    Card card3 = Card.dealOne(cardID);
    Card card4 = Card.dealOne(cardID);
    Card card5 = Card.dealOne(cardID);


    stringValue1 = ValueOfFace.toFace(card1.getValue());
    stringValue2 = ValueOfFace.toFace(card2.getValue());
    stringValue3 = ValueOfFace.toFace(card3.getValue());
    stringValue4 = ValueOfFace.toFace(card4.getValue());
    stringValue5 = ValueOfFace.toFace(card5.getValue());

    int higher = 1;
    int lower = 2;

    // Create Scanner to take name.  Print welcome message
    Scanner input = new Scanner(System.in);
    String userNameString = userName;

    //display 1st card and ask to guess if the next card will be higher & lower

    System.out.println("OK " + userNameString + "! The starting card is " + stringValue1 + " of " + card1.getSuit() + ".  Is the next card higher(1) or lower(2)?");
    card1.displayCard(card1.getPic());
    int guess = input.nextInt();

    if (guess == 1 && card2.getValue() > card1.getValue() ||
            guess == 2 && card2.getValue() < card1.getValue()) {
        System.out.println("Correct!  Card #2 was " + stringValue2 + " of " + card2.getSuit() + ".  Is the next card black(1) or red(2)?");
        card2.displayCard(card2.getPic());

    } else {
        System.out.println("Incorrect! Card #2 was " +  stringValue2 + " of " + card2.getSuit() + ". Would you like to try again? Yes(1)! Nah, I'm good(2)!");
        Card.runGame(userName);
    }


    int guess2 = input.nextInt();
    if (guess2 == 1 && card3.getSuit().equals("CLUBS") || guess2 == 1 && card3.getSuit().equals("SPADES")) {
        System.out.println("Correct!  Card #3 was " + stringValue3 + " of " + card3.getSuit() + ".  Is the next card higher(1) or lower(2)?");
        card3.displayCard(card3.getPic());
    } else if (guess2 == 2 && card3.getSuit().equals("HEARTS") || guess2 == 2 && card3.getSuit().equals("DIAMONDS")) {
        System.out.println("Correct!  Card #3 was " + stringValue3 + " of " + card3.getSuit() + ".  Is the next card higher(1) or lower(2)?");
        card3.displayCard(card3.getPic());

    } else {
        System.out.println("Incorrect! Card #3 was " + stringValue3 + " of " + card3.getSuit() + ". Would you like to try again? Yes(1)! Nah, I'm good(2)!");

    }
    int guess3 = input.nextInt();

    if (guess3 == 1 && card4.getValue() > card3.getValue() ||
            guess3 == 2 && card4.getValue() < card3.getValue()) {
        System.out.println("Correct!  Card #4 was " + stringValue4 + " of " + card4.getSuit() + ".  Is the next card black(1) or red(2)?");
        card4.displayCard(card4.getPic());
    } else {
        System.out.println("Incorrect! Card #4 was " + stringValue4 + " of " + card4.getSuit() + ". Would you like to try again? Yes(1)! Nah, I'm good(2)!");
    }
    int guess4 = input.nextInt();

    if (guess4 == 1 && card5.getSuit().equals("CLUBS") || guess4 == 1 && card5.getSuit().equals("SPADES")) {
        System.out.println("Correct!  Card #5 was " + stringValue5 + " of " + card5.getSuit() + ".  You've beaten the bus! Would you like to play again? Sure(1)! Retire a champ(2)!");
        card5.displayCard(card5.getPic());
    } else if (guess4 == 2 && card5.getSuit().equals("HEARTS") || guess4 == 2 && card5.getSuit().equals("DIAMONDS")) {
        System.out.println("Correct!  Card #5 was " + stringValue5 + " of " + card5.getSuit() + ".  You've beaten the bus! Would you like to play again? Sure(1)! Retire a champ(2)!");
        int playAgain = input.nextInt();
        card5.displayCard(card5.getPic());


    } else {
        System.out.println("Incorrect! Card #5 was " + card5 + ". So close!  Would you like to try again? Yes(1)! Nah, I'm good(2)!");
        int playAgain = input.nextInt();
        //System.exit(0);  //When exiting a process it's saying it's OK or 'normal'


        //System.out.println("Congrats!  You've won!");
    }
}
}