package scorecollection.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeMathUtils {
   // START:NewtonClass
   class Newton {
      static final double TOLERANCE = 1E-16;

      static double squareRoot(double n) {
         double approx = n;
         while (abs(approx - n / approx) > TOLERANCE * approx)
            approx = (n / approx + approx) / 2.0;
         return approx;
      }
   }
   // END:NewtonClass

   @Nested
   class SquareRoot {
      // START:verifiedWithInverse
      @Test
      public void verifiedWithInverse() {
         var result = Newton.squareRoot(250.0);
         assertEquals(250.0, result * result,
            Newton.TOLERANCE);
      }
      // END:verifiedWithInverse

      // START:verifiedUsingJavaLibrary
      @Test
      public void verifiedUsingJavaLibrary() {
         assertEquals(Math.sqrt(1969.0), Newton.squareRoot(1969.0),
            Newton.TOLERANCE);
      }
      // END:verifiedUsingJavaLibrary
   }
}
