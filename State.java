import java.util.ArrayList;
import java.util.List;

public class State implements Comparable<State>{
    private int posX, posY;
    private float price, heuristciValue, starPrice;
    private List<State> path;
    private State prevState;

    public State(int x, int y){
        this.posX = x; //Horizontal position.
        this.posY = y; //Vertical position.
        this.heuristciValue = 0F;
        this.price = 5F;
        this.path = new ArrayList<>();
        this.prevState = null;
        this.starPrice = 0F;
    }
    
    @Override
    public boolean equals(Object other) {
        return (this.posX == ((State)other).getPosX()) && (this.posY == ((State)other).getPosY());
    }

    @Override
    public int hashCode() {
        /* TODO if using data structures leveraging hash.
        *  IMPORTANT: It MUST be coherent with the "equals" method. That is, if two States are equal, they MUST have the same hashcode.
        *  However, due to collisions, two States with the same hashcode are not necessarily equal.  
        */
        //return Integer.parseInt(posX+""+posY);
        return this.hashCode();
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

    public List<State> getPath() {
        return path;
    }


    public void setPath(List<State> path) {
        this.path = path;
    }

    public float getHeuristciValue() {
        return heuristciValue;
    }

    public void setHeuristciValue(float heuristciValue) {
        this.heuristciValue = heuristciValue;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public State getPrevState() {
        return prevState;
    }

    public void setPrevState(State prevState) {
        this.prevState = prevState;
    }

    @Override
    public int compareTo(State otherState) {
        if(this.getHeuristciValue() > otherState.getHeuristciValue()){ return 1; }
        else if(this.getHeuristciValue() < otherState.getHeuristciValue()) { return -1;}
        return 0;
    }

    public float getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(float starPrice) {
        this.starPrice = starPrice;
    }
    
}
