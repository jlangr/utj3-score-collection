// START:CreditHistory
package scorecollection;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CreditHistory {
   private final List<CreditRating> ratings = new ArrayList<>();

   public void add(CreditRating rating) {
      ratings.add(rating);
   }
   // END:CreditHistory

   public void addCreditRating(int rating) {
      ratings.add(new CreditRating(rating, LocalDate.now()));
   }
   // START:CreditHistory

   public int arithmeticMean() {
      if (ratings.size() == 0) throw new IllegalStateException();

      // START_HIGHLIGHT
      var total = ratings.stream().mapToInt(CreditRating::rating).sum();
      // END_HIGHLIGHT
      return total / ratings.size();
   }
   // END:CreditHistory

   public long daysSpanned() {
      if (ratings.isEmpty()) return 0;
      if (ratings.size() == 1) return 1;
      var firstDate = ratings.get(0).date();
      var lastDate = ratings.get(ratings.size() - 1).date();
      return firstDate.until(lastDate, ChronoUnit.DAYS);
   }
// START:CreditHistory
}
// END:CreditHistory
