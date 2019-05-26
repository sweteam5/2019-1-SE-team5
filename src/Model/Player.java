package Model;

public class Player {
    private Array<Horse> hrr;
    private int pNn;

    public Player(int pNN, int hNum) {
        this.pNn = pNN;
        for(int i = 0; i < hNum; i++) {
            hrr.push(new Horse());
        }

        hrr[0].goStart();
    }
}