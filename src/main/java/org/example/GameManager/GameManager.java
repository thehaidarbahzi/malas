package org.example.GameManager;

import java.util.Scanner;

public class GameManager {
    public void startGame() {

    }

    void startCredits() {
        System.out.println("""
                JOGJA EXPERIENCE
                
                Our Team:
                Haidar
                Salwa
                Rasya
                Ariq
                Rasyid
                """);

        startMenu();
    }

    public int getInput() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Your input is not valid, please try again!");
                input.nextLine();
            }
        }

    }

    public void startMenu() {
        System.out.println("""
                JOGJA EXPERIENCE
                
                Menu:
                1. Start Game
                2. Credits
                3. Exit
                """);

        switch (getInput()) {
            case 1:
                startGame();
                break;
            case 2:
                startCredits();
                break;
            case 3:
                System.out.println("Thank you for playing our game!");
                System.exit(0);
                break;
        }
    }
}
