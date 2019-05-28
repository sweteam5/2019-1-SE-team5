package Model;

import java.util.Observable;

public class Model extends Observable {
    private Array<Yut> gYut;
    private int distance;
    private Array<Player> gPlayer;
    private Map gMap;
    private Array<Int> res;
    private int turn = 0;


    public Model(int pNumber, int hNumber) {
        for(int i = 0; i < pNumber; i++) {
            gPlayer.push(new Player(i+1, hNumber));
        }
        gMap = new Map();
    }

    public int throwYut() {
        distance = 0;
        for(int i = 0; i < 4; i++) {
            gYut[i].throwYut();
            if(gYut[i].getVal() == 1) distance++;
        }

        if(distance == 1 && gYut[3].getVal() == 1) return -1;
        else return distance;
    }

    public int throwYut(int num) {
        distance = num;
        Array<Int> res;
        if(num == -1) {
            for(int i = 0; i < 3; i++) {
                this.res[i] = 0;
            }
            this.res[3] = 1;
            return -1;
        } else {
            for(int i = 0; i < 4; i++) {
                if(num > 0) {
                    this.res[i] = 1;
                    num--;
                }
                else this.res[0] = 0;
            }
            return distance;
        }
    }

    public Array<Int> getThrown() {
        for(int i = 0; i < gYut.length(); i++) {
            res.push(gYut[i].getVal());
        }

        return res;
    }

    public void moveHrs(int hN, int distance, boolean dirChange) {
        gMap.delete(gPlayer[turn].whereHorse(hN)[0], gPlayer[turn].whereHorse(hN)[1]);
        gPlayer[turn].moveHrs(hN, distance, dirChange);
        int newX = gPlayer[turn].whereHorse(hN)[0];
        int newY = gPlayer[turn].whereHorse(hN)[1];
        if(!gMap.getInfo(newX, newY).isEmpty()) {
            if(gMap.getInfo(newX, newY).charAt(0) == Integer.toString(gPlayer[turn].getId())) {
                gPlayer[turn].grouping(hN, newX, newY);
                gMap.placeGroup(gPlayer[turn].getId(), newX, newY);
            } else {
                String temp = gMap.getInfo(newX, newY).charAt(0);
                for(int i = 0; i < gPlayer.length(); i++) {
                    if(i == turn) continue;
                    else {
                        if(gPlayer[i].getId() == Integer.valueOf(temp)) {
                            for(int j = 0; j < this.hNumber; j++) {
                                if(gPlayer[i].whereHorse(j)[0] = newX && gPlayer.whereHorse(j)[1] == newY) {
                                    gPlayer[i].goStart(j);
                                }
                            }
                        }
                    }
                }
                gMap.place(gPlayer[turn].getId(), newX, newY);
            }
        }
        if(distance != 0 && distance != 4) turn = (turn + 1) % 4;
    }

    public void endGame() {
        for(int i = 0; i < pNumber; i++) {
            if(gPlayer[i].isEnd() == true) break;
        }
    }
}