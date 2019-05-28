package Model;

class Map {
    private String gMap[][];

    public Map() {
        this.gMap = new String[10][10];
    }

    public void delete(int x, int y) {
        gMap[x][y] = "";
    }

    public void place(int id, int x, int y) {
        gMap[x][y] = Integer.toString(id);
    }

    public void placeGroup(int id, int x, int y) {
        gMap[x][y] = gMap[x][y].append(Integer.toString(id));
    }

    public String getInfo(int x, int y) {
        return gMap[x][y];
    }
}