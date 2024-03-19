import java.util.*;

public class AEstrella extends Search{
    
    boolean found;
    List<State> handledStates;
    List<State> pendingStates;

    public AEstrella(float[][] costMap, Heuristic heuristic){
        super(costMap, heuristic);
        found = false;
        handledStates = new ArrayList<>();
        pendingStates = new LinkedList<>();
    }

    @Override
    public List<State> DoSearch(State initialState, State targetState) {
        State actualState = null;
        pendingStates.add(initialState);
        List<State> solution = new ArrayList<State>();

        while(!found && !pendingStates.isEmpty()){
            Collections.sort(pendingStates); // Order pending states according to heuristic value obtained
            actualState = pendingStates.get(0); //First element
            pendingStates.remove(0);
            if(actualState.equals(targetState)){
                found = true;
                solution.add(actualState);
            } else {
                List<State> children = EvaluateOperators(actualState, targetState);
                for(State child : children){
                    if(!handledStates.contains(child)){ //If child is not handled
                        if(!pendingStates.contains(child)){
                            pendingStates.add(child);
                        } else if (pendingStates.get(pendingStates.indexOf(child)).getPrice() > child.getPrice()){
                            pendingStates.remove(child);
                            pendingStates.add(child);
                        }
                    } 
                }
                handledStates.add(actualState);
            }
        }
        if(found){ 
            while(actualState.getPrevState() != null){
                solution.add(actualState); /* Add all states to solution list */
                actualState = actualState.getPrevState();
            } 
            Collections.reverse(solution);
            System.out.println("Handled States: "+handledStates.size());
            return solution;
        } 
        else return null; /* Return null if not found */        
    }

    @Override
    protected List<State> EvaluateOperators(State currentState, State targetState) {
        List<State> children = new ArrayList<>();
        State child = null;
        float[][] costMap = getCostMap();

        /* Check map limits to avoid IndexOutOfBondsException */
        if(currentState.getPosX() < costMap.length-1){
            child = new State(currentState.getPosX()+1, currentState.getPosY());
            child.setHeuristciValue(super.getHeuristic().Evaluate(currentState, targetState, costMap));
            child.setPrice(costMap[currentState.getPosY()][currentState.getPosX()+1] + currentState.getPrice());
            child.setStarPrice(child.getHeuristciValue() + child.getPrice());
            child.setPrevState(currentState); //Set to child States the previous State
            children.add(child); //Down
        }
        if(currentState.getPosY() < costMap.length-1){
            child = new State(currentState.getPosX(), currentState.getPosY()+1);
            child.setHeuristciValue(super.getHeuristic().Evaluate(currentState, targetState, costMap));
            child.setPrice(costMap[currentState.getPosY()+1][currentState.getPosX()] + currentState.getPrice());
            child.setStarPrice(child.getHeuristciValue() + child.getPrice());
            child.setPrevState(currentState); //Set to child States the previous State
            children.add(child); //Right 
        }
        if(currentState.getPosX() > 0){
            child = new State(currentState.getPosX()-1, currentState.getPosY());
            child.setHeuristciValue(super.getHeuristic().Evaluate(currentState, targetState, costMap));
            child.setPrice(costMap[currentState.getPosY()][currentState.getPosX()-1] + currentState.getPrice());
            child.setStarPrice(child.getHeuristciValue() + child.getPrice());
            child.setPrevState(currentState); //Set to child States the previous State
            children.add(child); //Up
        }
        if(currentState.getPosY() > 0){
            child = new State(currentState.getPosX(), currentState.getPosY()-1);
            child.setHeuristciValue(super.getHeuristic().Evaluate(currentState, targetState, costMap));
            child.setPrice(costMap[currentState.getPosY()-1][currentState.getPosX()] + currentState.getStarPrice());
            child.setStarPrice(child.getHeuristciValue() + child.getPrice());
            child.setPrevState(currentState); //Set to child States the previous State
            children.add(child); //Left
        }
        return children;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public List<State> getHandledStates() {
        return handledStates;
    }

    public void setHandledStates(List<State> handledStates) {
        this.handledStates = handledStates;
    }

    public List<State> getPendingStates() {
        return pendingStates;
    }

    public void setPendingStates(List<State> pendingStates) {
        this.pendingStates = pendingStates;
    }
}
