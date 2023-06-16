package scorecollection;

import org.junit.jupiter.api.Test;
// START_HIGHLIGHT
import static org.junit.jupiter.api.Assertions.assertEquals;
// END_HIGHLIGHT

public class ACreditHistory {
   // START_HIGHLIGHT
   @Test
   void withNoCreditRatingsHasAMeanOf0() {
      var creditHistory = new CreditHistory();
      var result = creditHistory.arithmeticMean();
      assertEquals(0, result);
   }
   // END_HIGHLIGHT
}