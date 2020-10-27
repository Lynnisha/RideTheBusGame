package com.company.week1reviewexercise;

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
    public static String shuffleDeck() {
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

}