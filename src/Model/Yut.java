package Model;

import java.util.Random;

public class Yut {
    private int val;
    private boolean isBeak;
    Random rand = new Random();

    public Yut(int trigger) {
        this.val = 0;
        if ( trigger == 1 ) isBeak = true;
        else isBeak = false;
    }

    public boolean isBeak() {
        return isBeak;
    }

    public int getVal() {
        return val;
    }

    public void throwYut() {
        val = (int) rand.nextInt(2);
    }
}