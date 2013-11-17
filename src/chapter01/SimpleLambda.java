package chapter01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 */
public class SimpleLambda {
   public static void main(String[] args) {
      Integer[] numbers = {1, 2, 3};

      // reverse with anonymous class
      reverseWithAnonymousClass(numbers);
      System.out.println(Arrays.toString(numbers));

      // reverse with lambda
      reverseWithLambda(numbers);
      System.out.println(Arrays.toString(numbers));
   }

   private static void reverseWithLambda(Integer[] numbers) {
      Arrays.sort(numbers, (i1, i2) -> i2 - i1);
   }

   @SuppressWarnings("Convert2Lambda")
   private static void reverseWithAnonymousClass(Integer[] numbers) {
      Arrays.sort(numbers, new Comparator<Integer>() {
         @Override
         public int compare(Integer i1, Integer i2) {
            return i2 - i1;
         }
      });
   }
}
