
public class State implements Comparable<State>{
    private int posX, posY;
    private float price, heuristciValue, orderValue;
    private State prevState;

    public State(int x, int y){
        this.posX = x; //Horizontal position.
        this.posY = y; //Vertical position.
        this.heuristciValue = 0F;
        this.price = 5F;
        this.prevState = null;
        this.orderValue = 0F;
    }
    
    @Override
    public boolean equals(Object other) {
        return (this.posX == ((State)other).getPosX()) && (this.posY == ((State)other).getPosY());
        //return (this.hashCode() == other.hashCode());
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
        if(this.getOrderValue() > otherState.getOrderValue()){ return 1; }
        else if(this.getOrderValue() < otherState.getOrderValue()) { return -1; }
        else return 0;
    }

    public float getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(float orderValue) {
        this.orderValue = orderValue;
    }

    @Override
    public String toString() {
        return "("+ posY +"," + posX + ")";
    }
    
}
