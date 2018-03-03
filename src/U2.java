
public class U2 extends Rocket {
    @Override
    public Boolean launch() {
        double rate = 0.04*curMax;
        if(rate<Math.random()*0.1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean land() {
        double rate = 0.08*curMax;
        if(rate<Math.random()*0.1){
            return true;
        }
        return false;
    }
}
