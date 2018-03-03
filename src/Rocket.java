/**
 * Created by zfr on 18/2/2018
 * Rocket implement spaceship interface method
 */

public class Rocket implements SpaceShip {
    public int maxWeight;
    public int currentWeight;
    public double cost;
    public double curMax;
    @Override
    public Boolean launch() {
        return true;
    }

    @Override
    public Boolean land() {
        return true;
    }

    @Override
    public final Boolean canCarry(Item item) {
        if((this.currentWeight+item.weight)<=maxWeight){
            return true;
        }
        return false;
    }

    @Override
    public final void carry(Item item) {
        this.currentWeight+=item.weight;
    }
}
