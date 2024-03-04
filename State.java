import java.util.ArrayList;
import java.util.List;

public class State{
    private int posX, posY;
    List<String> path;

    public State(int x, int y){
        this.posX = x; //Horizontal position.
        this.posY = y; //Vertical position.
        this.path = new ArrayList<>();
    }
    

    @Override
    public boolean equals(Object other) {
        // TODO
        return (this.posX == ((State)other).getPosX()) && (this.posY == ((State)other).getPosY());
    }

    @Override
    public int hashCode() {
        /* TODO if using data structures leveraging hash.
        *  IMPORTANT: It MUST be coherent with the "equals" method. That is, if two States are equal, they MUST have the same hashcode.
        *  However, due to collisions, two States with the same hashcode are not necessarily equal.  
        */
        return Integer.parseInt(posX+""+posY);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public List<String> getPath() {
        return path;
    }


    public void setPath(List<String> path) {
        this.path = path;
    }
    
}
