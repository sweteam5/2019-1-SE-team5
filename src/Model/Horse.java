package Model;

import java.util.*;

public class Horse {
    private int placeX;
    private int placeY;
    private int direction;
    private boolean isEnd;
    private ArrayList<Horse> group;

    public Horse() {
        this.isEnd = false;
        this.group =new ArrayList<Horse>();
    }

    public void goStart() {
        /**
         * 현재 말과 그룹에 있는 말들을 모두 시작지점으로 보내버림
         */
        this.direction = 0;
        this.placeX = 10;
        this.placeY = 10;
        if(!this.group.isEmpty()) {
            for(int i = 0; i < this.group.size(); i++) {
                this.group.get(i).setPlace(0, 10, 10);
                this.group.get(i).endGroup();
            }
        }
        this.endGroup();
    }

    public void endGroup() {
        /**
         * 그룹용 기능: Array<Horse> group을 비움
         */
        this.group = null;
    }

    public ArrayList<Integer> getPlace() {
        /**
         * 현재 위치를 배열로 반환
         */
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0, this.placeX);
        res.add(1, this.placeY);
        return res;
    }

    public boolean getEnd() {
        /**
         * 현재 말이 끝났는지를 반환
         */
        return this.isEnd;
    }

    public void setEnd() {
        /**
         * 그룹용 기능: 업혀있는 말들을 끝난것으로 처리하기 위해
         */
        this.isEnd = true;
    }

    public void setPlace(int dir, int x, int y) {
        /**
         * 그룹용 기능: 업혀있는 말들을 현재 말들과 같은 위치로 가져옮
         */
        this.direction = dir;
        this.placeX = x;
        this.placeY = y;
    }

    public void pushGroup(Horse hrs) {
        this.group.push(hrs);
    }

    public void move(int distance, boolean dirChange) {
        /**
         * 말을 정해진 거리만큼 움직이는 기능
         */
        if(this.isEnd == true) {
            // 이미 끝난 말은 움직일 수 없음
            return;
        }

        if(distance == -1) {
            // 빽도
            if (this.placeX == 10 && this.placeY == 10) return;
            else {
                if(this.direction >= 0 && this.direction <= 3) {
                    int temp = this.direction;
                    this.direction = (this.direction + 2) % 4;
                    this.move(1, false);
                    this.direction = temp;
                } else {
                    int temp = this.direction;
                    if(this.direction == 4) this.direction = 5;
                    else this.direction = 4;
                    this.move(1, false);
                    this.direction = temp;
                }
            }
            return;
        }

        int moved = 0;
        while(distance > 0) {
            /**
             * 한번 움직일 때마다 distance를 1씩 줄이면서 움직임
             */
            if(moved == 0 && dirChange == true) {
                // 방향을 바꿀 수 있는 위치에서 바꾸도록 신호가 오면 대각선 방향으로 꺾음
                if (this.placeX == 10 & this.placeX == 0) {
                    this.direction = 4;
                } else if (this.placeX == 0 && this.placeY == 0) {
                    this.direction = 5;
                } else if(this.placeX == 5 && this.placeY == 5) {
                    this.direction = 5;
                }
            }
            /**
             * 현재 방향에 맞게 말의 좌표를 변경
             */
            if(this.direction == 0) {
                this.placeY -= 2;
            } else if(this.direction == 1) {
                this.placeX -= 2;
            } else if(this.direction == 2) {
                this.placeY += 2;
            } else if(this.direction == 3) {
                this.placeX += 2;
            } else if(this.direction == 4) {
                if((this.placeX == 6 && this.placeY == 4) || (this.placeX == 5 && this.placeY == 5)) {
                    this.placeX--;
                    this.placeY--;
                } else {
                    this.placeX -= 2;
                    this.placeY -= 2;
                }
            } else {
                if((this.placeX == 4 && this.placeY == 4) || (this.placeX == 5 && this.placeY == 5)) {
                    this.placeX++;
                    this.placeY--;
                } else {
                    this.placeX += 2;
                    this.placeY -= 2;
                }
            }

            moved++;
            distance--;


            // 움직이는 도중에 벽에 닿으면 바로 방향을 바꿔줌
            if(this.placeX == 0 && this.placeY == 0) this.direction++;
            else if(this.placeX == 10 && this.placeY == 0) this.direction++;
            else if(this.placeX == 0 && this.placeY == 10) this.direction++;
            if(this.placeX == 10 && this.placeY == 10 && moved > 0) {
                /**
                 * 1회 이상 움직여서 시작지점으로 돌아온 경우, 이 말과
                 * 업혀있는 모든 말을 끝난 상태로 바꿈
                 */
                this.isEnd = true;
                if(this.group.size() > 0) {
                    for(int i = 0; i < this.group.size(); i++) {
                        this.group.get(i).setEnd();
                    }
                }
                break;
            }
        }

        if(this.group.size() > 0) {
            /**
             * 모든 이동이 끝난 이후에 그룹에 있는 말들을 현재 말과 같은 위치에 놓음
             */
            for(int i = 0; i < this.group.size(); i++) {
                this.group.get(i).setPlace(this.direction, this.placeX, this.placeY);
            }
        }
    }
}