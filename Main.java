import java.util.*;
public class Main {

    private static int totalPrice = 0;
    private static int nDays = 0;
    private static List<State> solution;

    public static char[][] OriginalCharMap = {
      {'P','N','N','N','P','P','P','P','P','P'},
      {'P','N','N','N','M','M','P','P','N','P'},
      {'P','N','N','N','M','M','N','N','N','P'},
      {'P','A','A','A','A','A','A','N','N','N'},
      {'P','N','A','C','A','A','A','A','A','N'},
      {'P','A','A','C','M','C','C','A','A','A'},
      {'P','A','M','A','M','M','C','A','A','A'},
      {'A','A','M','A','M','C','C','P','M','P'},
      {'A','A','M','C','M','C','P','P','P','P'},
      {'A','A','C','C','M','C','C','C','C','C'},
    };
    public static Map OriginalMap = new Map(OriginalCharMap);

    public static char[][] CustomCharMap = {
      {'N','N','N','N','N'},
      {'N','N','N','N','N'},
      {'N','N','N','N','N'},
      {'N','N','N','N','N'},
      {'N','N','N','N','N'},
    };
    public static Map CustomMap = new Map(CustomCharMap);

    public static void main(String args[]){      

      // TODO: Declare map
      Map map = new Map(OriginalCharMap);

      // TODO: Declare initial and target states
      State initialState = new State(0,0);
      State targetState = new State(9,9);

      // Declare heuristics
      Heuristic[] heuristics = new Heuristic[3];
      heuristics[0] = Heuristics::Heuristic1;
      heuristics[1] = Heuristics::Heuristic2;
      heuristics[2] = Heuristics::Heuristic3;

      // TODO: Declare search algorithms (if desired, you can move this under "Run experiments")
      Search bestFirst = new BestFirst(map.getCostMap(), heuristics[0]);
      Search bestFirstV2 = new BestFirst(map.getCostMap(), heuristics[1]);

      // TODO: Run experiments
      solution = bestFirst.DoSearch(initialState, targetState);
      //solution = bestFirstV2.DoSearch(initialState, targetState);

      // TODO: Show results
      System.out.println("--- RESULTS OBTAINED ---\n");
      System.out.println("Path to solution: ");
      for(int i = 0; i < solution.size()-1; i++){
        System.out.print("( "+solution.get(i).getPosX()+" , "+solution.get(i).getPosY()+" ) ");
        System.out.print("-> ");
        totalPrice += solution.get(i).getPrice();
        nDays++;
      }
      System.out.println();
      System.out.println("TOTAL PRICE: "+totalPrice);
      System.out.println("NUMBER OF DAYS: "+nDays);
    }

}



