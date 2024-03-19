import java.util.*;
public class Main {

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
      {'C','M','M','C','N'},
      {'P','P','A','A','C'},
      {'A','P','A','N','P'},
      {'A','M','A','C','N'},
      {'N','M','C','M','N'},
    };
    public static Map CustomMap = new Map(CustomCharMap);

    public static void main(String args[]){      

      // TODO: Declare map
      float[][] map = OriginalMap.getCostMap();
      float[][] custMap = CustomMap.getCostMap();

      // TODO: Declare initial and target states
      State initialState = new State(0,0);
      initialState.setPrice(2F);
      State targetState = new State(map.length-1, map.length-1);
      State targetStateCust = new State(custMap.length-1, custMap.length-1);
      targetState.setPrice(0.5F);
      targetStateCust.setPrice(0.5F);

      // Declare heuristics
      Heuristic[] heuristics = new Heuristic[3];
      heuristics[0] = Heuristics::Heuristic1;
      heuristics[1] = Heuristics::Heuristic2;
      heuristics[2] = Heuristics::Heuristic3;

      // TODO: Declare search algorithms (if desired, you can move this under "Run experiments")

      // TODO: Run experiments

      // TODO: Show results
      System.out.println("--------- RESULTS OBTAINED ---------\n");

      for(int i = 0; i < heuristics.length; i++){
        BestFirst bFirst = new BestFirst(map, heuristics[i]);
        List<State> solution = bFirst.DoSearch(initialState, targetState);
        System.out.println("BestFirst with Heuristic "+(i+1) + " has the following path: ");
        System.out.println(solution.toString());
        System.out.println("Number of days: "+solution.size());
        System.out.println("TOTAL PRICE: "+solution.get(solution.size()-1).getPrice()+" coins\n");

        AEstrella aStar = new AEstrella(map, heuristics[i]);
        solution = aStar.DoSearch(initialState, targetState);
        System.out.println("aStar with Heuristic " + (i+1) + " has the following path: ");
        System.out.println(solution.toString());
        System.out.println("Number of days: "+solution.size());
        System.out.println("TOTAL PRICE: "+solution.get(solution.size()-1).getPrice()+" coins\n");
      }

      System.out.println("--------- CUSTOM MAP ---------\n");

      for(int i = 0; i < heuristics.length; i++){
        BestFirst bFirst = new BestFirst(custMap, heuristics[i]);
        List<State> solution = bFirst.DoSearch(initialState, targetStateCust);
        System.out.println("BestFirst with Heuristic "+(i+1) + " has the following path: ");
        System.out.println(solution.toString());
        System.out.println("Number of days: "+solution.size());
        System.out.println("TOTAL PRICE: "+solution.get(solution.size()-1).getPrice()+" coins\n");

        AEstrella aStar = new AEstrella(custMap, heuristics[i]);
        solution = aStar.DoSearch(initialState, targetStateCust);
        System.out.println("aStar with Heuristic " + (i+1) + " has the following path: ");
        System.out.println(solution.toString());
        System.out.println("Number of days: "+solution.size());
        System.out.println("TOTAL PRICE: "+solution.get(solution.size()-1).getPrice()+" coins\n");
      }

    }
}



