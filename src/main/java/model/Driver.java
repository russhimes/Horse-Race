package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(new BigDecimal("100.00"));
        List<Horse> horses = new ArrayList<>();
        Horse buttercup = new Buttercup();
        horses.add(buttercup);
        Horse nightMare = new NightMare();
        horses.add(nightMare);
        boolean quit = false;

        while (true) {
            System.out.println("You have: $" + player.getMoney().setScale(2, RoundingMode.HALF_UP));
            pause();
            boolean isValidChoice = false;
            int choiceInt = -1;
            while (!isValidChoice) {
                isValidChoice = true;
                System.out.println("Type the Number of the Horse you'd like to bet on or type Q to quit!");
                pause();
                for (Horse horse : horses) {
                    System.out.println((horses.indexOf(horse)+1) + ") " + horse.getName());
                    System.out.println(horse.getDescription());
                    pause();
                }
                System.out.print("Selection: ");
                String choice = scanner.nextLine();
                if (choice.toUpperCase().equals("Q")) return;
                try{choiceInt = parseInt(choice);}
                catch(NumberFormatException e){isValidChoice = false;}
                if (choiceInt < 0 || choiceInt > horses.size()) isValidChoice = false;
            }
            BigDecimal numChoice = new BigDecimal("-1.00");
            isValidChoice = false;
            while (!isValidChoice) {
                isValidChoice = true;
                System.out.println("How much would you like to bet?");
                System.out.print("Amount: ");
                String choice = scanner.nextLine();
                try {numChoice = new BigDecimal(choice);}
                catch (NumberFormatException e) {return;}
                if (numChoice.compareTo(new BigDecimal("0.00")) == -1 || numChoice.compareTo(player.getMoney()) == 1) isValidChoice = false;
            }
            System.out.println("Enjoy The Race!\n");
            BigDecimal bet = numChoice.setScale(2, RoundingMode.HALF_UP);
            HorseRace race = new HorseRace(horses);
            Horse winner = race.runRace();
            race.printResult();
            if (winner.equals(horses.get(choiceInt-1))) player.setMoney(player.getMoney().add(bet));
            else player.setMoney(player.getMoney().subtract(bet));
            if (player.getMoney().compareTo(BigDecimal.ZERO) == 0) {
                System.out.println("Sorry, you're broke!  Better luck next time!");
                return;
            }
            race.cleanUp();
        }

    }

    public static void pause() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            return;
        }
    }
}
