package scorecollection;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ACreditHistory {
   @Test
   void withNoCreditRatingsHas0Mean() {
      var creditHistory = new CreditHistory();
      int result = creditHistory.arithmeticMean();
      assertEquals(0, result);
   }

   @Test
   void withOneRatingHasEquivalentMean() {
      var creditHistory = new CreditHistory();
      creditHistory.add(new CreditRating(780, LocalDate.now()));
      int result = creditHistory.arithmeticMean();
      // START:oneBasedTest
      assertEquals(780, result);
      // END:oneBasedTest
   }
}