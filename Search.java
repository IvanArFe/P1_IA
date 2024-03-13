import java.util.List;

public abstract class Search {
    private float[][] costMap;
    private Heuristic heuristic; 

    public Search(float[][] costMap, Heuristic heuristic){
        this.costMap = costMap;
        this.heuristic = heuristic;
    }

    /*
    protected class atributesStruct {
        private int heuristicResult;
        List<String> path;

        public atributesStruct(){
            heuristicResult = 0;
            path = new ArrayList<>();
        }

        public int getHeuristicResult() {
            return heuristicResult;
        }

        public void setHeuristicResult(int heuristicResult) {
            this.heuristicResult = heuristicResult;
        }

        public List<String> getPath() {
            return path;
        }

        public void setPath(List<String> path) {
            this.path = path;
        }
        
    } 

    /* Volem que la cerca sigui d'un estat inicial al final. Es pot canviar el tipus de retorn. */
    public List<State> DoSearch(State initialState, State targetState){
        /* TODO: Implement search algorithm
         * You CANNOT change the input parameters (i.e., initial and target state).
         * However, feel free to use inheritance, auxiliar methods and/or change the return type. */
         return null;
    }    

    protected List<State> EvaluateOperators(State currentState, State targetState, Heuristic chosenHeuristic){
        /* TODO: Obtain the states that can be accessed from the current state.
         * Consider their cost, heuristic...
         * Feel free to change the input parameters and/or return type.
         */
        return null;
    }

    public float[][] getCostMap() {
        return costMap;
    }

    public void setCostMap(float[][] costMap) {
        this.costMap = costMap;
    }

    public Heuristic getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }
    
}
