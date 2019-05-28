package Model;

class Map {
    private String gMap[][];

    public Map() {
        this.gMap = new String[10][10];
    }

    public void delete(int id, int x, int y) {
        gMap[x][y] = "";
    }

    public void place(int id, int x, int y) {
        gMap[x][y] = Integer.toString(id);
    }
}