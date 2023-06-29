package scorecollection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals; // <label id="co.import"/>

class ACreditHistory {
   @Test
   void withNoCreditRatingsHas0Mean() { // <label id="co.name"/>
      var creditHistory = new CreditHistory(); // <label id="co.arrange"/>
      int result = creditHistory.arithmeticMean(); // <label id="co.act"/>
      assertEquals(0, result); // <label id="co.assert"/>
   }
}