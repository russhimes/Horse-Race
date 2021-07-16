package model;

import java.util.concurrent.ThreadLocalRandom;

public class Buttercup extends Horse {
    private String description = "A sweet-natured horse who believes slow and steady wins the race";

    public Buttercup() {
        super("Buttercup");
    }

    @Override
    public void run() {
        int value = ThreadLocalRandom.current().nextInt(0,4);
        if (value == 0) this.setPosition(this.getPosition()+1);
        if (value == 1) this.setPosition(this.getPosition()+1);
        if (value == 2) this.setPosition(this.getPosition()+1);
        if (value == 3) this.setPosition(this.getPosition()+2);
    }
    @Override
    public String getDescription() {
        return this.description;
    }
}
