import java.lang.Math;
public class Heuristics {
    private static float result = 0;
    public static float Heuristic1(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        /* Distance heuristic */
        result = (float) Math.sqrt( ((targetState.getPosX()- currentState.getPosX())^2) +
                ((targetState.getPosY()- currentState.getPosY())^2));
        return result;
    }

    public static float Heuristic2(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        
        return result;
    }

    public static float Heuristic3(State currentState, State targetState, float[][] map){
        /* TODO: Implement a heuristic 
         * You CANNOT change the input parameters and return type.
         * The value returned can ONLY be based on the current state and the target state, NOT intermediate states.
         */
        return result;
    }
}
