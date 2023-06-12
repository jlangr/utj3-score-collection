// START:all
package scorecollection;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class CreditHistory {
   private final List<CreditRating> ratings = new ArrayList<>();
   
   public void add(CreditRating scoreable) {
      ratings.add(scoreable);
   }
   
   public int arithmeticMean() {
      var total = ratings.stream().mapToInt(CreditRating::rating).sum();
      return total / ratings.size();
   }
   // END:all

   // START:main
   public static void main(String[] args) {
      var start = LocalDate.of(2025, Month.JANUARY, 1);
      var collection = new CreditHistory();
      collection.add(new CreditRating(745, start));
      collection.add(new CreditRating(714, start.plusDays(1)));
      collection.add(new CreditRating(758, start.plusDays(2)));
      collection.add(new CreditRating(805, start.plusDays(3)));

      System.out.println("average: " + collection.arithmeticMean());
   }
   // END:main
   // START:all
}
// END:all
