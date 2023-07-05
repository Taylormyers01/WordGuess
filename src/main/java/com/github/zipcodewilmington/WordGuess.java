package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGuess {
    String[] words = {"cat", "dog", "bird", "fish", "lizard", "snake", "turtle", "hamster"};
    static String currentWord;
    static String[] guesses;
    static Boolean correctGuess;
    static int numOfGuesses = 0;
    static Scanner input = new Scanner(System.in);
    public WordGuess(){
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        currentWord = words[index];
        //System.out.println(currentWord);
        correctGuess = false;
        numOfGuesses = currentWord.length() + 3;
        guesses = new String[currentWord.length()];
        Arrays.fill(guesses, " _ ");
        /*
        for(int i = 0; i<guesses.length; i++){
            guesses[i] = " _ ";
        }

         */


    }
    public static void runGame(){
        System.out.println("\nLet's Play Wordguess version 2.0");
        while (!correctGuess) {
                currentGuesses();
                System.out.println("You have " + numOfGuesses + " tries left.");
                captureGuess();
                checkWinCondition();

        }


    }
    public static void checkWinCondition(){
        boolean contains = Arrays.stream(guesses).anyMatch(" _ "::equals);
        if(contains && numOfGuesses == 0){
            correctGuess = true;
            System.out.println("GAME OVER. You have ran out of guesses");
        }
        else if(!contains && numOfGuesses >= 0){
            correctGuess = true;
            System.out.println("YOU WIN! You have guessed correctly!");
        }
    }

    public static void captureGuess(){
        System.out.println("Enter a single Character");
        char hold = input.nextLine().charAt(0);
        if (hold == '-'){
            correctGuess = true;
        }
        for(int i = 0; i < currentWord.length(); i++){
            if(currentWord.charAt(i) == hold){
                guesses[i] = " " + hold + " ";
            }
        }
        numOfGuesses--;

    }
    public static void currentGuesses(){
        StringBuilder sb = new StringBuilder();
        sb.append("Current Guesses:\n");
        for (String word : guesses){
            sb.append(word);
        }
        System.out.println(sb.toString());
    }
    public static boolean playAgain(){
        boolean runningLoop = true;
        boolean output = false;
        while(runningLoop){
            System.out.println("Would you like to play again? y/n");
            String response = input.nextLine();
            if(response.equalsIgnoreCase("n")){
                System.out.println("Thank you for playing!");
                //output = false;
                runningLoop = false;

            } else if (response.equalsIgnoreCase("y")) {
                System.out.println("Starting new round!");
                output = true;
                runningLoop = false;
            }
            else {
                System.out.println("You have input an invalid response.");
            }
        }
        return output;
    }
    public static void main(String[] args) {
        boolean cont = true;
        while(cont){

            WordGuess game = new WordGuess();
            game.runGame();
            cont = playAgain();

        }
    }
}
