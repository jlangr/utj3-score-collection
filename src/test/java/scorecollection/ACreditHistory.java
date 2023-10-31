package scorecollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.*;

class ACreditHistory {
   CreditHistory creditHistory;

   @BeforeEach
   void createInstance() {
      creditHistory = new CreditHistory();
   }

   @Test
   void withNoCreditRatingsHas0Mean() {
      assertThrows(IllegalStateException.class,
         () -> creditHistory.arithmeticMean());
   }

   @Test
   void disallowsAddingNullCreditRating() {
      assertThrows(IllegalArgumentException.class,
         () -> creditHistory.add(null));
   }

   @Test
   void withOneRatingHasEquivalentMean() {
      creditHistory.add(new CreditRating(780, LocalDate.now()));

      int result = creditHistory.arithmeticMean();

      assertEquals(780, result);
   }

   @Test
   void withMultipleRatingsDividesTotalByCount() {
      creditHistory.add(new CreditRating(780, LocalDate.now()));
      creditHistory.add(new CreditRating(800, LocalDate.now()));
      creditHistory.add(new CreditRating(820, LocalDate.now()));

      int result = creditHistory.arithmeticMean();

      assertEquals(800, result);
   }

   @Test
   public void improperlyHandlesOverflow() {
      creditHistory.add(new CreditRating(Integer.MAX_VALUE, LocalDate.now()));
      creditHistory.add(new CreditRating(1, LocalDate.now()));

      int result = creditHistory.arithmeticMean();

      assertTrue(creditHistory.arithmeticMean() < 0);
   }

   @Nested
   class DaysSpanned {
      @Test
      void isZeroWhenRatingsIsEmpty() {
         assertEquals(0, new CreditHistory().daysSpanned());
      }

      @Test
      void isZeroWhenOneRatingExists() {
         creditHistory.add(new CreditRating(640, LocalDate.now()));

         var result = creditHistory.daysSpanned();

         assertEquals(1, result);
      }

      @Test
      void isDaysBetweenFirstAndLastRatingDate() {
         creditHistory.add(new CreditRating(640, LocalDate.of(2024, Month.JANUARY, 10)));
         creditHistory.add(new CreditRating(640, LocalDate.of(2024, Month.JANUARY, 15)));
         creditHistory.add(new CreditRating(640, LocalDate.of(2024, Month.JANUARY, 20)));

         var result = creditHistory.daysSpanned();

         assertEquals(20 - 10, result);
      }
   }

   @Nested
   class FindViaPredicate {
      @Test
      void returnsMatchingCreditRatings() {
         creditHistory.add(new CreditRating(600, LocalDate.now()));
         creditHistory.add(new CreditRating(639, LocalDate.now()));
         creditHistory.add(new CreditRating(740, LocalDate.now()));
         creditHistory.add(new CreditRating(780, LocalDate.now()));

         var results = creditHistory.find(r -> r.rating() < 740);

         var inverseRatings = creditHistory.ratings().stream()
                 .filter(r -> r.rating() >= 740)
                 .map(CreditRating::rating)
                 .collect(toSet());
         var ratings = results.stream()
                 .map(CreditRating::rating)
                 .collect(toSet());
         ratings.addAll(inverseRatings);
         assertEquals(Set.of(600, 639, 740, 780), ratings);
      }
   }
}
