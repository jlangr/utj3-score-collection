package scorecollection;

// START_HIGHLIGHT
import org.junit.jupiter.api.BeforeEach;
// END_HIGHLIGHT
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ACreditHistory {
   // START_HIGHLIGHT
   CreditHistory creditHistory;
   // END_HIGHLIGHT

   // START_HIGHLIGHT
   @BeforeEach
   void createInstance() {
      creditHistory = new CreditHistory();
   }
   // END_HIGHLIGHT

   @Test
   void withNoCreditRatingsHas0Mean() {
      int result = creditHistory.arithmeticMean();

      assertEquals(0, result);
   }

   @Test
   void withOneRatingHasEquivalentMean() {
      creditHistory.add(new CreditRating(780, LocalDate.now()));

      int result = creditHistory.arithmeticMean();

      assertEquals(780, result);
   }
}
