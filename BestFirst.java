import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BestFirst extends Search{
    
    boolean found;
    List<State> handledStates;
    List<State> pendingStates;

    public BestFirst(float[][] costMap, Heuristic heuristic){
        super(costMap, heuristic);
        found = false;
        handledStates = new ArrayList<>();
        pendingStates = new LinkedList<>();
    }

    @Override
    public List<State> DoSearch(State initialState, State targetState) {
        // TODO Auto-generated method stub
        State actualState = null;
        pendingStates.add(initialState);
        List<State> solution = new ArrayList<State>();
        
        while(!found && !pendingStates.isEmpty()){
            actualState = pendingStates.get(0); //First element
            pendingStates.remove(0);
            if(actualState.equals(targetState)){
                found = true;
                solution.add(actualState);
            } else {
                List<State> children = EvaluateOperators(actualState, targetState, getHeuristic());
                for(State child : children){
                    if(!handledStates.contains(child) && !pendingStates.contains(child)){ //If child is not handled
                        pendingStates.add(child);
                        child.setPrevState(actualState); //Set to child States the previous State
                        Collections.sort(pendingStates); // Order pending states according to heuristic value obtained
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
            return solution;
        } 
        else return null; /* Return null if not found */
    }

    @Override
    protected List<State> EvaluateOperators(State currentState, State targetState, Heuristic chosenHeuristic) {
        List<State> children = new ArrayList<>();
        State child = null;
        float[][] costMap = getCostMap();

        /* Check map limits to avoid IndexOutOfBondsException */
        if(currentState.getPosX() < 9){
            child = new State(currentState.getPosX()+1, currentState.getPosY());
            child.setHeuristciValue(chosenHeuristic.Evaluate(child, targetState, getCostMap()));
            child.setPrice(costMap[currentState.getPosY()][currentState.getPosX()+1]);
            children.add(child); //Down
        }
        if(currentState.getPosY() < 9){
            child = new State(currentState.getPosX(), currentState.getPosY()+1);
            child.setHeuristciValue(chosenHeuristic.Evaluate(child, targetState, getCostMap()));
            child.setPrice(costMap[currentState.getPosY()+1][currentState.getPosX()]);
            children.add(child); //Right 
        }
        if(currentState.getPosX() > 0){
            child = new State(currentState.getPosX()-1, currentState.getPosY());
            child.setHeuristciValue(chosenHeuristic.Evaluate(child, targetState, getCostMap()));
            child.setPrice(costMap[currentState.getPosY()][currentState.getPosX()-1]);
            children.add(child); //Up
        }
        if(currentState.getPosY() > 0){
            child = new State(currentState.getPosX(), currentState.getPosY()-1);
            child.setHeuristciValue(chosenHeuristic.Evaluate(child, targetState, getCostMap()));
            child.setPrice(costMap[currentState.getPosY()-1][currentState.getPosX()]);
            children.add(child); //Left
        }

        return children;
    }
    
    
}
