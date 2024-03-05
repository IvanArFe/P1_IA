import java.lang.Math;
public class Heuristics {
    private static float result = 0;
    public static float Heuristic1(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        /* Distance heuristic based on Pitagoras equation */
        double sum = (Math.pow(targetState.getPosX() - currentState.getPosX(), 2) 
            + Math.pow(targetState.getPosY() - currentState.getPosY(), 2));
        return (float) Math.sqrt(sum); 
    }

    public static float Heuristic2(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        /* Based on cost of current state */
        return map[currentState.getPosY()][currentState.getPosX()];
    }

    public static float Heuristic3(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        return result;
    }
}
