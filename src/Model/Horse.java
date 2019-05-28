package Model;

public class Horse {
    private int placeX;
    private int placeY;
    private int direction;
    private boolean isEnd;
    private Arary<Horse> group;

    public Horse() {
        this.isEnd = false;
    }

    public goStart() {
        this.direction = 0;
        this.placeX = 10;
        this.placeY = 10;
    }

    public Array<Int> getPlace() {
        Array<Int> res;
        res[0] = this.placeX;
        res[1] = this.placeY;
        return res;
    }

    public boolean getEnd() {
        return this.isEnd;
    }

    public void move(int distance, boolean dirChange) {
        if(this.isEnd == true) {
            // already end
            return;
        }

        if(distance == -1) {
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
            if(moved == 0 && dirChange == true) {
                if (this.placeX == 10 & this.placeX == 0) {
                    this.direction = 4;
                } else if (this.placeX == 0 && this.placeY == 0) {
                    this.direction = 5;
                } else if(this.placeX == 5 && this.placeY == 5) {
                    this.direction = 5;
                }
            }
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

            if(this.placeX == 0 && this.placeY == 0) this.direction++;
            else if(this.placeX == 10 && this.placeY == 0) this.direction++;
            else if(this.placeX == 0 && this.placeY == 10) this.direction++;
            if(this.placeX == 10 && this.placeY == 10 && moved > 0) {
                this.isEnd = true;
                break;
            }
        }
    }
}