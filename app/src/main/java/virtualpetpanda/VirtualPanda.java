package virtualpetpanda;

import java.util.Timer;
import java.util.TimerTask;

public class VirtualPanda {
    private int hunger = 10;
    private int thirst = 10;
    private int boredom = 10;
    private Timer timer;
    private Timer selfCareTimer;

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
        selfCareTimer = new Timer();
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
        timer.schedule(new CloserToDeathTimeLoop(), 0, 30000);
    }

    public void startAutoHealth() {
        selfCareTimer.schedule(new startAutoHealth(), 30000, 60000);
    }

    private class startAutoHealth extends TimerTask {
        @Override
        public void run() {
            int max = Math.max(hunger, Math.max(hunger, boredom));
            if (hunger == max) {
                hunger -= 10;
                if (hunger < 0) {
                    hunger = 0;
                }
                if (thirst == max) {
                    thirst -= 10;
                    if (thirst < 0) {
                        thirst = 0;
                    }
                }
                if (boredom == max) {
                    boredom -= 10;
                    if (boredom < 0) {
                        boredom = 0;
                    }
                }
            }
        }
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
