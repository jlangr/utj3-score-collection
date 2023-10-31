// START:stream
package scorecollection;

// END:stream
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
// START:stream
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// ... more imports
// END:stream
import java.util.function.Predicate;
// START:stream
import java.util.stream.Stream;

public class CreditHistory {
   private final List<CreditRating> ratings = new ArrayList<>();

   public void add(CreditRating rating) {
      if (rating == null) throw new IllegalArgumentException();
      ratings.add(rating);
   }
   // ...
// END:stream

   public void addCreditRating(int rating) {
      ratings.add(new CreditRating(rating, LocalDate.now()));
   }

   public int arithmeticMean() {
      if (ratings.size() == 0) throw new IllegalStateException();

      var total = ratings.stream()
                     .mapToInt(CreditRating::rating)
                     .sum();
      return total / ratings.size();
   }

   public long daysSpanned() {
      if (ratings.isEmpty()) return 0;
      if (ratings.size() == 1) return 1;
      var firstDate = ratings.get(0).date();
      var lastDate = ratings.get(ratings.size() - 1).date();
      return firstDate.until(lastDate, ChronoUnit.DAYS);
   }

   public List<CreditRating> find(Predicate<CreditRating> predicate) {
      return ratings.stream().filter(predicate).toList();
   }
// START:stream

   List<CreditRating> ratings() {
      return ratings;
   }

   // START_HIGHLIGHT
   public Stream<CreditRating> stream() {
   // END_HIGHLIGHT
      var reversedRatings = new ArrayList<>(ratings);
      Collections.reverse(reversedRatings);
      return reversedRatings.stream();
   }
}
// END:stream
