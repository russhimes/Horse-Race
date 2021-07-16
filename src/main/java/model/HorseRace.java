package model;

import model.Horse;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static model.Driver.pause;

public class HorseRace {
    private Map<Horse, List<Integer>> horsePositions;
    private Horse winner;
    private List<Horse> horses;

    public HorseRace(List<Horse> horses) {
        this.horses = horses;
        this.horsePositions = new HashMap<>();
        for (Horse current : horses) {
            this.horsePositions.put(current, new ArrayList<Integer>());
            this.horsePositions.get(current).add(0);
        }
    }
    public Horse runRace() {
        boolean isRacing = true;
        while (isRacing) {
            for (Horse current : horses) {
                current.run();
                this.horsePositions.get(current).add(current.getPosition());
                if (current.getPosition() >= 16) isRacing = false;
            }
        }
        int winningPosition = 12;
        List<Horse> tiedWinners = new ArrayList<>();
        for (Horse current : horses) {
            if (current.getPosition() >= 12) tiedWinners.add(current);
        }
        int randomSelect = ThreadLocalRandom.current().nextInt(0, tiedWinners.size());
        winner = tiedWinners.get(randomSelect);
        return winner;
    }

    public void printResult() {
        Set<Horse> keySet = this.horsePositions.keySet();
        for (int i = 0; i <= 12; i++) {
            if (i == 12){
                System.out.println("=============");
                pause();
            }

            for (Horse current : keySet) {
                if (i == 12) {
                    if (current.equals(winner)) System.out.print(current.getName().substring(0, 1) + " | ");
                    else System.out.print("  | ");
                }
                else {
                    if (this.horsePositions.get(current).contains(i)) System.out.print(current.getName().substring(0, 1) + " | ");
                    else System.out.print("  | ");
                }
            }
            System.out.print("\n");
            pause();
        }
        System.out.println(winner.getName() + " Wins!\n");
    }

    public void cleanUp() {
        winner = null;
        horsePositions = new HashMap<>();
        for (Horse current : horses) {
            current.setPosition(0);
            this.horsePositions.put(current, new ArrayList<>());
            this.horsePositions.get(current).add(0);
        }
    }
}
