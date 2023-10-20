// START:find
package scorecollection;

// ...
// END:find
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// START:find
public class CreditHistory {
   private final List<CreditRating> ratings = new ArrayList<>();

   public void add(CreditRating rating) {
      if (rating == null) throw new IllegalArgumentException();
      ratings.add(rating);
   }
   // ...
   // END:find

   public void addCreditRating(int rating) {
      ratings.add(new CreditRating(rating, LocalDate.now()));
   }

   // START:overflow
   public int arithmeticMean() {
      if (ratings.size() == 0) throw new IllegalStateException();

      var total = ratings.stream()
                     .mapToInt(CreditRating::rating)
                     .sum();
      return total / ratings.size();
   }
   // END:overflow

   public long daysSpanned() {
      if (ratings.isEmpty()) return 0;
      if (ratings.size() == 1) return 1;
      var firstDate = ratings.get(0).date();
      var lastDate = ratings.get(ratings.size() - 1).date();
      return firstDate.until(lastDate, ChronoUnit.DAYS);
   }

   // START:find
   public List<CreditRating> find(Predicate<CreditRating> predicate) {
      return ratings.stream().filter(predicate).toList();
   }

   List<CreditRating> ratings() {
      return ratings;
   }
}
// END:find