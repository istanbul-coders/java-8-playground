package chapter12;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @version 1.0
 */
public class VariableScoping {
   private static double number = 0;

   public static void main(String[] args) {
      // Lambdas are lexicallay scoped, meaning you can access/modify outer class variables, not the anonymous class

      // 1: below won't compile since x is defined in the outer class scope
//      double x = 0;
//      Function<Double, Double> lambda1 = x -> x + 1;

      // 2: below won't compile since x is defined in the outer class scope again
//      double x = 0;
//      Predicate<Double> lambda2 = y -> {
//         double x = 1;
//         return false;
//      };

      // 3: below won't compile since effective final x cannot be re-assigned
//      double x = 0;
//      Predicate<Double> lambda3 = y -> {
//         x = 3;
//         return false;
//      };

      // 4: you can re-assign instance/static variables in the lambda scope
//      Predicate<Double> lambda4 = x -> {
//         number = 3;
//         return false;
//      };

      // 5: you can define variable names that are also instance/static variables
//      Predicate<Double> lambda5 = number -> {
//         VariableScoping.number = 3 + number;
//         return false;
//      };
   }
}
