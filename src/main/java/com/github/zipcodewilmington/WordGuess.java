package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGuess {
    String[] words = {"cat", "dog", "bird", "fish"};
    static String currentWord;
    static String[] guesses;
    static Boolean correctGuess;
    static int numOfGuesses = 0;
    static Scanner input = new Scanner(System.in);
    public WordGuess(){
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        currentWord = words[index];
        System.out.println(currentWord);
        correctGuess = false;
        numOfGuesses = currentWord.length();
        guesses = new String[currentWord.length()];
        for(int i = 0; i<guesses.length; i++){
            guesses[i] = " _ ";
        }


    }
    public static void runGame(){
        System.out.println("\nLet's Play Wordguess version 1.0");

        while(correctGuess == false){
            currentGuesses();
            System.out.println("You have "+ numOfGuesses+ " tries left.");
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

    public static void main(String[] args) {
        WordGuess game = new WordGuess();
        game.runGame();
    }
}
