package virtualpetpanda;

import java.util.Timer;
import java.util.TimerTask;

public class VirtualPanda {
    private int hunger = 10;
    private int thirst = 10;
    private int boredom = 10;
    private Timer timer;

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public VirtualPanda(int hunger, int thirst, int boredom) {
        this.hunger = hunger;
        this.thirst = thirst;
        this.boredom = boredom;
        timer = new Timer();
    }

    public void feed() {
        hunger -= 10;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void drink() {
        thirst -= 10;
        if (thirst < 0) {
            thirst = 0;
        }
    }

    public void play() {
        boredom -= 10;
        if (boredom < 0) {
            boredom = 0;
        }
    }

    public void startCloserToDeath() {
        timer.schedule(new CloserToDeathTimeLoop(), 0, 6000);
    }

    private class CloserToDeathTimeLoop extends TimerTask {
        @Override
        public void run() {
            hunger += 10;
            thirst += 10;
            boredom += 10;
        }
    }
}
