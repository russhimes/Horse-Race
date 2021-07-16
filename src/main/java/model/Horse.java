package model;

import java.util.concurrent.ThreadLocalRandom;

public class Horse {
    private String name;
    private int position = 0;

    public Horse(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getDescription() {
        return "A completely unremarkable horse.";
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void run(){
        position += ThreadLocalRandom.current().nextInt(0,3);
    }
}
