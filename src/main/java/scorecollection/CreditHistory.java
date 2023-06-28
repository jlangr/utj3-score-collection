package scorecollection;

import java.util.ArrayList;
import java.util.List;

public class CreditHistory {
   private final List<CreditRating> ratings = new ArrayList<>();
   // START:breakTheTest
   public void add(CreditRating rating) {
      // START_HIGHLIGHT
//      ratings.add(rating);
      // END_HIGHLIGHT
   }

   public int arithmeticMean() {
      if (ratings.size() == 0) return 0;

      var total = ratings.stream().mapToInt(CreditRating::rating).sum();
      return total / ratings.size();
   }
   // END:breakTheTest
}
