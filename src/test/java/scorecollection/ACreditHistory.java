package scorecollection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; // <callout id="co.import"

public class ACreditHistory {
   @Test
   void withNoCreditRatingsHasAMeanOf0() { // <callout id="co.name">
      var creditHistory = new CreditHistory(); // <callout id="co.arrange">
      int result = creditHistory.arithmeticMean(); // <callout id="co.act">
      assertEquals(0, result); // <callout id="co.assert">
   }
}