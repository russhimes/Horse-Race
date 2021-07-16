package model;

import java.util.concurrent.ThreadLocalRandom;

public class NightMare extends Horse{
    private final String description = "A spirited mare who tends to be stubborn.  Her performance is unpredictable.";

    public NightMare() {
        super("Nightmare");
    }

    @Override
    public void run() {
        int value = ThreadLocalRandom.current().nextInt(0,4);
        if (value == 0 || value == 1) this.setPosition(this.getPosition()+0);
        if (value == 2) this.setPosition(this.getPosition()+2);
        if (value == 3) this.setPosition(this.getPosition()+3);
    }
    @Override
    public String getDescription() {
        return this.description;
    }

}
