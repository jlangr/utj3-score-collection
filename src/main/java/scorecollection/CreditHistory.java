package scorecollection;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CreditHistory {
   private final List<CreditRating> ratings = new ArrayList<>();

   public void add(CreditRating rating) {
      if (rating == null) throw new IllegalArgumentException();
      ratings.add(rating);
   }

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

   List<CreditRating> ratings() {
      return ratings;
   }

// START:stream
   public Stream<CreditRating> stream() {
      return ratings.stream().sorted(
              Comparator.comparing(CreditRating::date).reversed());
   }
}
// END:stream
