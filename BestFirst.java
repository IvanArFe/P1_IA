import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BestFirst extends Search{
    
    boolean found;
    List<State> handledStates;
    Queue<State> pendingStates;

    public BestFirst(float[][] costMap, Heuristic heuristic){
        super(costMap, heuristic);
        found = false;
        handledStates = new ArrayList<>();
        pendingStates = new LinkedList<>();
    }

    @Override
    public List<State> DoSearch(State initialState, State targetState) {
        // TODO Auto-generated method stub
        State actualState;
        List<State> solution = new ArrayList<>();
        
        while(!found && !pendingStates.isEmpty()){
            actualState = pendingStates.peek();
            pendingStates.poll();
            if(actualState.equals(targetState)){
                found = true;
                solution.add(actualState);
            } else {
                for(State child : actualState.getChildren()){
                    if(!handledStates.contains(child) && !pendingStates.contains(child)){ //If child is not handled
                        pendingStates.add(child);
                    } 
                }
                handledStates.add(actualState);
            }
        }
        if(found){ return solution; } 
        else return null;
    }
    
}
