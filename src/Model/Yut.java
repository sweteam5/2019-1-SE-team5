package Model;

import java.util.Random;

public class Yut {
    private int val;
    Random rand = new Random();

    public Yut() {
        this.val = 0;
    }

    public int getVal() {
        return val;
    }

    public void throwYut() {
        val = (int) rand.nextInt(2);
    }
}