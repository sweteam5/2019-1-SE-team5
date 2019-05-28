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
        /**
         * 이 플레이어가 끝났는지를 체크
         * 모든 말의 isEnd가 true이면 true,
         * 아니면 false를 반환
         */
        int tmp = 0;
        for(int i = 0 ; i < hrr.length(); i++) {
            if(hrr[i].getEnd() == true) tmp++;
        }

        if(tmp == hrr.length()) return true;
        else return false;
    }

    public boolean isEnd(int hN) {
        /**
         * hN번 말이 끝났는지를 반환
         */
        return hrr(hN).getEnd();
    }

    public void moveHrs(int hN, int distance, boolean dirChange) {
        /**
         * hN번 말을 distance만큼 움직임
         */
        hrr[hN].move(distance, dirChange);
    }

    public int getId() {
        /**
         * PlayerID 반환
         */
        return this.pNn;
    }

    public void goStart(int hN) {
        /**
         * hN번 말을 시작지점으로 보냄
         */
        hrr[hN].goStart();
    }

    public void grouping(int hN, int x, int y) {
        /**
         * 좌표를 받으면 그 좌표에 있는 말이 hN번 말을 업게 함
         * 반대로도 함
         */
        for(int i = 0; i < hrr.length(); i++) {
            if(i == hN) continue;
            else {
                if(hrr[i].getPlace()[0] == x && hrr[i].getPlace()[1] == y) {
                    hrr[i].pushGroup(hrr[hN]);
                    hrr[hN].pushGroup(hrr[i]);
                }
            }
        }
    }

    public Array<Int> whereHorse(int hN) {
        /**
         * hN번 말의 위치를 Array<Int>형태로 반환
         */
        return hrr[hN].getPlace();
    }
}