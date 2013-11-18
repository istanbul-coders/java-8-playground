package chapter02;

import java.util.Arrays;

/**
 * @version 1.0
 */
public class TypeInferencing {
   public static void main(String[] args) {
      Integer[] numbers = {1, 2, 3};

      // watch type inferences, no need to define Integer
      Arrays.sort(numbers, (i1, i2) -> { return (i2 - i1); });

      System.out.println(Arrays.toString(numbers));
   }

}
