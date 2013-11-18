package chapter11;

import java.util.function.BinaryOperator;

/**
 * @version 1.0
 */
public class BinaryOperators {
   public static void main(String[] args) {
      BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;

      System.out.println(adder.apply(3, 4));
   }
}
