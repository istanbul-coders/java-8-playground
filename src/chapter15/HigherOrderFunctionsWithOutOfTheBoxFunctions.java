package chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @version 1.0
 */
public class HigherOrderFunctionsWithOutOfTheBoxFunctions {
   public static void main(String[] args) {
      Function<Double, Double> square = number -> number * number;
      Function<Double, Double> half = number -> number / 2;

      List<Double> numbers = Arrays.asList(10D, 4D, 12D);

      // watch out the order
      System.out.println(mapIt(numbers, square.compose(half)));
      System.out.println(mapIt(numbers, half.compose(square)));

      // you can chain them
      System.out.println(mapIt(numbers, half.andThen(square)));

      // you can use identity to not modify them
      System.out.println(mapIt(numbers, Function.<Double>identity()));
   }

   private static List<Double> mapIt(List<Double> numbers, Function<Double, Double> fx) {
      List<Double> result = new ArrayList<>();

      for (Double number : numbers) {
         result.add(fx.apply(number));
      }

      return result;
   }
}
