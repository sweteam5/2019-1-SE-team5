package Model;

import java.util;

public class Model extends Observable {
    private Array<Yut> gYut;
    private int distance;
    private Array<Player> gPlayer;
    private Map gMap;
    private Array<Int> res;
    private int turn = 0;
    private boolean isEnd;


    public Model(int pNumber, int hNumber) {
        for(int i = 0; i < pNumber; i++) {
            gPlayer.push(new Player(i+1, hNumber));
        }
        gMap = new Map();
        this.isEnd = false;
    }

    public int throwYut() {
        /**
         * 윷을 모두 던지고 결과를 거리로 반환함
         */
        distance = 0;
        for(int i = 0; i < 4; i++) {
            gYut[i].throwYut();
            if(gYut[i].getVal() == 1) distance++;
        }

        if(distance == 1 && gYut[3].getVal() == 1) return -1;
        else return distance;
        setChanged();
        notifyObservers();
    }

    public int throwYut(int num) {
        /**
         * 미리 설정한 값대로 윷을 던진 결과가 나오게 함
         * (지정 던지기)
         */
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
        /**
         * 던져진 윷의 결과를 배열로 넘겨줌
         */
        for(int i = 0; i < gYut.length(); i++) {
            res.push(gYut[i].getVal());
        }

        return res;
    }

    public void moveHrs(int hN, int distance, boolean dirChange) {
        /**
         * 현재 turn의 플레이어의 hN번 말을 distance만큼 움직임
         * dirChange값은 기본적으로 false로 넘길 것
         * 말이 방향을 바꿀 수 있는 위치에 있고 방향을 꺾도록 선택되었다면 true를 넘기면 됨
         */
        String tmp;
        if(gPlayer[turn].whereHorse(hN)[0] == 10 && gPlayer[turn].whereHorse(hN)[1] == 10) {
            // 말이 시작위치에 있다면 현재 턴인 플레이어의 ID를,
            tmp = Integer.toString(gPlayer[turn].getId());
        } else {
            // 아니라면 현재 말의 위치에 따라 맵에 저장되어있는 스트링 값을 저장해둠 (새로운 위치에 넣을 때 사용)
            tmp = gMap.getInfo(gPlayer[turn].whereHorse(hN)[0], gPlayer[turn].whereHorse(hN)[1]);
        }

        // 맵에서 말이 움직이기 전 위치를 비우고
        gMap.delete(gPlayer[turn].whereHorse(hN)[0], gPlayer[turn].whereHorse(hN)[1]);

        // 말을 움직임
        gPlayer[turn].moveHrs(hN, distance, dirChange);

        int newX = gPlayer[turn].whereHorse(hN)[0];
        int newY = gPlayer[turn].whereHorse(hN)[1];

        // 이하의 코드는 맵의 새로운 위치에 말을 넣는 역할
        if(!gMap.getInfo(newX, newY).isEmpty()) {
            /**
             * 말의 새로운 위치에 이미 다른 말이 있는 경우
             */
            if(gMap.getInfo(newX, newY).charAt(0) == Integer.toString(gPlayer[turn].getId())) {
                /**
                 * 그것이 현재 턴인 플레이어의 말이라면 업게 함
                 */
                gPlayer[turn].grouping(tmp, newX, newY);
                gMap.placeGroup(gPlayer[turn].getId(), newX, newY);
            } else {
                /**
                 * 다른 플레이어의 말이라면 그 말을 시작지점으로 돌려보내고(업혀있는 말까지 모두)
                 * 내 말을 그 자리에 둠
                 */
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
                gMap.place(tmp, newX, newY);
            }
        } else {
            /**
             * 비어있는 칸이라면 그냥 말을 그자리에 위치시킨다.
             */
            gMap.place(tmp, newX, newY);
        }
        if(distance != 0 && distance != 4) turn = (turn + 1) % 4;
        setChanged();
        notifyObservers();
    }

    public int whoTurn() {
        // 누구의 턴인지 출력 (PlayerID : turn + 1)
        return turn + 1;
    }

    public String mapAt(int x, int y) {
        // 맵의 특정 위치의 값을 읽음
        return gMap.getInfo(x, y);
    }

    public boolean endGame() {
        /**
         * 게임이 끝났는지를 판단.
         * moveHrs() 메소드를 실행시킨 뒤에 꼭 한번씩 체크해줄 것
         */
        for(int i = 0; i < pNumber; i++) {
            if(gPlayer[i].isEnd() == true) {
                this.isEnd = true;
                break;
            }
        }
        return this.isEnd;
    }
}