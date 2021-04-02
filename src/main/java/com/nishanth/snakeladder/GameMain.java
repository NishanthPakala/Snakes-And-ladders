package com.nishanth.snakeladder;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class GameMain {
    public static Map<Integer, Integer> getSnakePositions(){
        Map<Integer,Integer> snakePositions = new TreeMap<Integer,Integer>();
        snakePositions.put(54,17);
        snakePositions.put(68,47);
        snakePositions.put(82,21);
        snakePositions.put(96,43);
        return snakePositions;
    }
    public static Map<Integer,Integer> getLadderPositions(){
        Map<Integer, Integer> ladderPositions = new TreeMap<Integer,Integer>();
        ladderPositions.put(5,35);
        ladderPositions.put(30,53);
        ladderPositions.put(59,83);
        ladderPositions.put(67,73);
        return ladderPositions;
    }
    public static int rollDice(){
        Random random = new Random();
        int diceValue = random.nextInt(7-1)+1;
        System.out.println("Dice value is "+diceValue);
        return diceValue;
    }

    public static void main(String args[]) {
    System.out.println("Welcome to snake and ladder tournament");
    System.out.println("Enter number of users");
    Map<Integer,Integer> ladderPositions = getLadderPositions();
    Map<Integer,Integer> snakePositions = getSnakePositions();
    Scanner scan= new Scanner(System.in);
    int noOfParticipants = scan.nextInt();
    System.out.println("Number of players is"+ noOfParticipants);
    boolean isGameEnd = false;
    int currentPlayer = 1;
    Integer score[] = new Integer[noOfParticipants];
    for(int i=0; i < noOfParticipants; i++){
        score[i]=0;
        }

    while(!isGameEnd){
        System.out.println("Player is "+currentPlayer);
        System.out.println("Player is"+currentPlayer + "Score is "+score[currentPlayer-1]);
        boolean isSnakeBite =false;
        boolean isLadderClimb =false;
        boolean isDiceSix =false;
        System.out.println("Enter some key to roll Dice");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        int diceValue = rollDice();

        isDiceSix = (diceValue ==6);
        int tempScore = score[currentPlayer-1]+diceValue;
        if(tempScore == 100){
            isGameEnd = true;
            System.out.println("Winner is"+currentPlayer);
        }
        if(snakePositions.containsKey(tempScore)){
            System.out.println("snake bite");
            tempScore = snakePositions.get(tempScore);
            isSnakeBite = true;
        }
        else
        {
            if(ladderPositions.containsKey(tempScore)){
                System.out.println("ladder Climb");
                tempScore = ladderPositions.get(tempScore);
                isLadderClimb = true;
            }
        }
        if(tempScore <= 100)
        score[currentPlayer -1] = tempScore;
        if(!isSnakeBite && (tempScore <= 100) && (isDiceSix || isLadderClimb)){
        System.out.println("Current user"+currentPlayer+"get retry");
        } else
        {
            if(currentPlayer == noOfParticipants){
                currentPlayer =1;
            }else
            {
                currentPlayer++;
            }
        }
    }
    }
}
