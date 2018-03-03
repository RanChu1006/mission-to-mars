/**
 * Created by zfr on 18/2/2018
 * SpaceShip interface   for method
 */

public interface SpaceShip {
    public Boolean launch();
    public Boolean land();
    public Boolean canCarry(Item item);
    public void carry(Item item);
}
