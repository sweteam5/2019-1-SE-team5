package Model;

class Map {
    private String gMap[][];

    public Map() {
        this.gMap = new String[11][11];
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                gMap[i][j]="";
            }
        }
    }

    public void delete(int x, int y) {
        gMap[x][y] = "";
    }

    public void place(String id, int x, int y) {
        gMap[x][y] = id;
    }

    public void placeGroup(String id, int x, int y) {
        gMap[x][y] = gMap[x][y] + id;
    }

    public String getInfo(int x, int y) {
        return gMap[x][y];
    }

    public String[] getMap() {
        return this.gMap;
    }

}