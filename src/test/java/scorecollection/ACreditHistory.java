package scorecollection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; // <label id="co.import"/>

public class ACreditHistory {
   @Test
   void withNoCreditRatingsHasAMeanOf0() { // <label id="co.name"/>
      var creditHistory = new CreditHistory(); // <label id="co.arrange"/>
      int result = creditHistory.arithmeticMean(); // <label id="co.act"/>
      assertEquals(0, result); // <label id="co.assert"/>
   }
}