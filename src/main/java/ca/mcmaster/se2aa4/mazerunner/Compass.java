package ca.mcmaster.se2aa4.mazerunner;

public class Compass{
    private final StringBuilder path;

 
    

    public Compass(){
        path = new StringBuilder();
    }

    public void move(Direction direction) {
        switch (direction) {
            case FORWARD -> path.append("F");
            case RIGHT -> path.append("R");
            case LEFT -> path.append("L");
        }
    }

    public String getPath() {
        return path.toString();
    }


}