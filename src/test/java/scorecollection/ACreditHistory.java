package scorecollection;

import org.junit.jupiter.api.Test;
// START_HIGHLIGHT
import static org.junit.jupiter.api.Assertions.assertEquals; // <callout id="co.import"
// END_HIGHLIGHT

public class ACreditHistory {
   // START_HIGHLIGHT
   @Test
   void withNoCreditRatingsHasAMeanOf0() { // <callout id="co.name"
      var creditHistory = new CreditHistory(); // <callout id="co.arrange"
      int result = creditHistory.arithmeticMean(); // <callout id="co.act"
      assertEquals(0, result); // <callout id="co.assert"
   }
   // END_HIGHLIGHT
}