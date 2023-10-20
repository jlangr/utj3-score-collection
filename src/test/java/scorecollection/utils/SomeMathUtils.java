package scorecollection.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomeMathUtils {
   // START:NewtonClass
   public class Newton {
      static final double ACCURACY = 1E-8;

      public static double squareRoot(double n) {
         double approximation = n / 2;
         while (abs(approximation * approximation - n) > ACCURACY)
            approximation = (approximation + n / approximation) / 2.0;
         return approximation;
      }
   }
   // END:NewtonClass

   @Nested
   class SquareRoot {
      // START:verifiedWithInverse
      @Test
      void verifiedWithInverse() {
         var result = Newton.squareRoot(250.0);
         assertEquals(250.0, result * result,
            Newton.ACCURACY);
      }
      // END:verifiedWithInverse

      // START:verifiedUsingJavaLibrary
      @Test
      void verifiedUsingJavaLibrary() {
         assertEquals(Math.sqrt(1969.0), Newton.squareRoot(1969.0),
            Newton.ACCURACY);
      }
      // END:verifiedUsingJavaLibrary

      // START:run
      long time(int times, Consumer<Integer> func) {
         var start = System.nanoTime();
         IntStream.range(0, times).forEach(i -> func.accept(i + 1));
         return (System.nanoTime() - start) / 1_000_000;
      }
      // END:run

      // START:performance
      @Test
      void executesInSufficientTime() {
         var numberOfTimes = 100_000;

         var elapsedMs = time(numberOfTimes, i -> Newton.squareRoot(i));

         assertTrue(elapsedMs < 1000);
      }
      // END:performance
   }
}
