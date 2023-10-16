// START:null
package scorecollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ACreditHistory {
   CreditHistory creditHistory;

   @BeforeEach
   void createInstance() {
      creditHistory = new CreditHistory();
   }
   // END:null
   @Test
   void withNoCreditRatingsHas0Mean() {
      assertThrows(IllegalStateException.class,
         () -> creditHistory.arithmeticMean());
   }
   // START:null

   @Test
   void throwsExceptionWhenAddingNull() {
      creditHistory.add(null);
      creditHistory.arithmeticMean();
   }
   // END:null

   @Test
   void withOneRatingHasEquivalentMean() {
      creditHistory.add(new CreditRating(780, LocalDate.now()));

      int result = creditHistory.arithmeticMean();

      assertEquals(780, result);
   }

   // START:happyPath
   @Test
   void withMultipleRatingsDividesTotalByCount() {
      creditHistory.add(new CreditRating(780, LocalDate.now()));
      creditHistory.add(new CreditRating(800, LocalDate.now()));
      creditHistory.add(new CreditRating(820, LocalDate.now()));

      int result = creditHistory.arithmeticMean();

      assertEquals(800, result);
   }
   // START:happyPath

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
   // START:null
}
// END:null
