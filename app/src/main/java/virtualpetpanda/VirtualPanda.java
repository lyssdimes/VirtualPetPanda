package virtualpetpanda;

public class VirtualPanda {
    private int hunger = 10;
    private int thirst = 10;
    private int boredom = 10;


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
    }

    public int feed(VirtualPanda pan){
        int panCurrentHunger = pan.getHunger();
        int panNewHunger = panCurrentHunger - 10;
        return panNewHunger;
    }
    public int drink(VirtualPanda pan){
        int panCurrentThirst = pan.getThirst();
        int panNewThirst = panCurrentThirst - 10;
        return panNewThirst;
    }
    public int play(VirtualPanda pan){
        int panCurrentBoredom = getBoredom();
        int panNewBoredom = panCurrentBoredom - 10;
        return panNewBoredom;
    }


}
