package scorecollection;

import java.util.*;

public class ScoreCollection {
   private final List<Scoreable> scores = new ArrayList<>();
   
   public void add(Scoreable scoreable) {
      scores.add(scoreable);
   }
   
   public int arithmeticMean() {
      var total = scores.stream().mapToInt(Scoreable::score).sum();
      return total / scores.size();
   }

   public static void main(String[] args) {
      var collection = new ScoreCollection();
      collection.add(new Item(5, "a"));
      collection.add(new Item(7, "b"));
      collection.add(new Item(9, "c"));

      System.out.println("average: " + collection.arithmeticMean());
   }
}
