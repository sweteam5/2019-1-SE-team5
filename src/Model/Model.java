package Model;

import java.util.*;
import java.util.Observable.*;

public class Model extends Observable {
    private ArrayList<Yut> gYut = new ArrayList<Yut>();
    private int distance;
    private ArrayList<Player> gPlayer = new ArrayList<Player>();
    private Map gMap;
    private int turn = 0;
    private boolean isEnd;
    private int pNumber;
    private int hNumber;

    public Model(String psvalue[]) {
        this.pNumber = Integer.parseInt(psvalue[0]);
        this.hNumber = Integer.parseInt(psvalue[1]);
        for(int i = 0; i < pNumber; i++) {
            gPlayer.add(new Player(i+1, hNumber));
        }
        gMap = new Map();
        for(int i = 0; i < 4; i++) {
            gYut.add(new Yut());
        }
    }

    public int throwYut() {
        /**
         * 윷을 모두 던지고 결과를 거리로 반환함
         */
        distance = 0;
        for(int i = 0; i < 4; i++) {
            gYut.get(i).throwYut();
            if(gYut.get(i).getVal() == 1) distance++;
        }

        if(distance == 0) return 5;
        else if(distance == 1 && gYut.get(3).getVal() == 1) return 0;
        else return distance;
        /*setChanged();
        notifyObservers();*/
    }

    public int throwYut(int num) {
        /**
         * 미리 설정한 값대로 윷을 던진 결과가 나오게 함
         * (지정 던지기)
         */
        ArrayList<Integer> res = new ArrayList<Integer>();
        distance = num;
        if(num == 0) {
            for(int i = 0; i < 3; i++) {
                res.add(0);
            }
            res.add(1);
            return -1;
        } else if(num == 5) {
            for(int i = 0; i < 4; i++) {
                res.add(0);
            }
            return distance;
        } else {
            for(int i = 0; i < 4; i++) {
                if(num > 0) {
                    res.add(1);
                    num--;
                }
                else res.add(0);
            }
            return distance;
        }
    }

    public ArrayList<Int> getThrown() {
        /**
         * 던져진 윷의 결과를 배열로 넘겨줌
         */
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < gYut.size(); i++) {
            res.add(gYut.get(i).getVal());
        }

        return res;
    }

    public void moveHrs(int hN, int distance, boolean dirChange) {
        /**
         * 현재 turn의 플레이어의 hN번 말을 distance만큼 움직임
         * dirChange값은 기본적으로 false로 넘길 것
         * 말이 방향을 바꿀 수 있는 위치에 있고 방향을 꺾도록 선택되었다면 true를 넘기면 됨
         */
        int eat = 0;
        String tmp;
        if(gPlayer.get(turn).whereHorse(hN).get(0) == 10 && gPlayer.get(turn).whereHorse(hN).get(1) == 10) {
            // 말이 시작위치에 있다면 현재 턴인 플레이어의 ID를,
            tmp = Integer.toString(gPlayer.get(turn).getId());
        } else {
            // 아니라면 현재 말의 위치에 따라 맵에 저장되어있는 스트링 값을 저장해둠 (새로운 위치에 넣을 때 사용)
            tmp = gMap.getInfo(gPlayer.get(turn).whereHorse(hN).get(0), gPlayer.get(turn).whereHorse(hN).get(1));
        }

        // 맵에서 말이 움직이기 전 위치를 비우고
        gMap.delete(gPlayer.get(turn).whereHorse(hN).get(0), gPlayer.get(turn).whereHorse(hN).get(1));

        // 말을 움직임
        gPlayer.get(turn).moveHrs(hN, distance, dirChange);
        System.out.println(gPlayer.get(turn).whereHorse(hN));

        int newX = gPlayer.get(turn).whereHorse(hN).get(0);
        int newY = gPlayer.get(turn).whereHorse(hN).get(1);

        // 이하의 코드는 맵의 새로운 위치에 말을 넣는 역할
        if(gMap.getInfo(newX, newY) != "") {
            /**
             * 말의 새로운 위치에 이미 다른 말이 있는 경우
             */
            if(gMap.getInfo(newX, newY).charAt(0) == Integer.toString(gPlayer.get(turn).getId()).charAt(0)) {
                /**
                 * 그것이 현재 턴인 플레이어의 말이라면 업게 함
                 */
                gPlayer.get(turn).grouping(Integer.valueOf(tmp), newX, newY);
                gMap.placeGroup(String.valueOf(gPlayer.get(turn).getId()), newX, newY);
            } else {
                /**
                 * 다른 플레이어의 말이라면 그 말을 시작지점으로 돌려보내고(업혀있는 말까지 모두)
                 * 내 말을 그 자리에 둠
                 */
                String temp = gMap.getInfo(newX, newY).substring(0, 1);
                for(int i = 0; i < gPlayer.size(); i++) {
                    if(i == turn) continue;
                    else {
                        if(gPlayer.get(i).getId() == Integer.valueOf(temp)) {
                            for(int j = 0; j < this.hNumber; j++) {
                                if(gPlayer.get(i).whereHorse(j).get(0) == newX && gPlayer.get(i).whereHorse(j).get(1) == newY) {
                                    gPlayer.get(i).goStart(j);
                                }
                            }
                        }
                    }
                }
                eat++;
                gMap.place(tmp, newX, newY);
            }
        } else {
            /**
             * 비어있는 칸이라면 그냥 말을 그자리에 위치시킨다.
             */
            gMap.place(tmp, newX, newY);
        }
        if(distance != 5 && distance != 4 && eat == 0) turn = (turn + 1) % gPlayer.size();
        // setChanged();
        // notifyObservers();

    }

    public int whoTurn() {
        // 누구의 턴인지 출력 (PlayerID : turn + 1)
        return turn + 1;
    }

    public boolean hrsEnd(int pN, int hN) {
        return gPlayer.get(pN).isEnd(hN);
    }

    public ArrayList<Integer> hrsInfo(int pN, int hN) {
        return this.gPlayer.get(pN).whereHorse(hN);
    }

    public String mapAt(int x, int y) {
        // 맵의 특정 위치의 값을 읽음
        return gMap.getInfo(x, y);
    }

    public String[] getMap() {
        // 전체 맵의 정보 반환
        return gMap.getMap();
    }

    public boolean endGame() {
        /**
         * 게임이 끝났는지를 판단.
         * moveHrs() 메소드를 실행시킨 뒤에 꼭 한번씩 체크해줄 것
         */
        for(int i = 0; i < pNumber; i++) {
            if(gPlayer.get(i).isEnd() == true) {
                this.isEnd = true;
                break;
            }
        }
        return this.isEnd;
    }
}