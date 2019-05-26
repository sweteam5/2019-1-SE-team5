package Model;

import java.util.Observable;

public class Model extends Observable {
    private Array<Yut> gYut;
    private Array<Int> pRes;
    // private int distance;
    private Array<Player> gPlayer;

    public Model(int pNum, int hNum) {
        for(int i = 0; i < 3; i++) {
            this.gYut[i] = new Yut(0);
        }
        this.gYut[3] = new Yut(1);

        for(int i = 0; i < pNum; i++) {
            gPlayer.push(new Player(i+1, hNum));
        }
    }
}