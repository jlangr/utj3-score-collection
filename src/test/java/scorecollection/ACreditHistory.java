package scorecollection;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

// START:testClass
public class ACreditHistory {
   @Test
   void withNoCreditRatingsHas0Mean() {
      var creditHistory = new CreditHistory();

      int result = creditHistory.arithmeticMean();

      assertEquals(0, result);
   }

   // START:scannability
   @Test
   void withOneRatingHasEquivalentMean() {
      // START:arrange
      var creditHistory = new CreditHistory();
      // END:arrange
      creditHistory.add(new CreditRating(780, LocalDate.now()));

      int result = creditHistory.arithmeticMean();

      assertEquals(780, result);
   }
   // END:scannability
}
// END:testClass
