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

    public boolean isEnd() {
        int tmp = 0;
        for(int i = 0 ; i < hrr.length(); i++) {
            if(hrr[i].getEnd() == true) tmp++;
        }

        if(tmp == hrr.length()) return true;
        else return false;
    }

    public void moveHrs(int hN, int distance, boolean dirChange) {
        hrr[hN].move(distance, dirChange);
    }

    public int getId() {
        return this.pNn;
    }
}