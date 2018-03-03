/**
 * Created by zfr on 18/2/2018
 * U1 rocket
 */

public class U1 extends Rocket {
    @Override
    public Boolean launch() {
        double rate = 0.05*curMax;
        if(rate<Math.random()*0.1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean land() {
        double rate = 0.01*curMax;
        if(rate<Math.random()*0.1){
            return true;
        }
        return false;
    }
}
