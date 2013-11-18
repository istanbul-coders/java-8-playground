package chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @version 1.0
 */
public class MethodReferences {
   public static void main(String[] args) {
      List<Double> numbers = Arrays.asList(1D, 25D, 100D);
      List<String> names = Arrays.asList("john", "jane", "oliver");

      System.out.println(transformNumbers(numbers, Math::sqrt));
      System.out.println(transformStrings(names, "PREFIX: "::concat));
      System.out.println(transformStrings(names, String::toUpperCase));
      System.out.println(maker(Employee::new));
   }

   private static List<String> transformNumbers(List<Double> numbers, Function<Double, Double> fx) {
      List<String> appliedNumbers = new ArrayList<>();

      for (Double n : numbers) {
         appliedNumbers.add(String.valueOf(fx.apply(n)));
      }

      return appliedNumbers;
   }

   private static List<String> transformStrings(List<String> names, Function<String, String> fx) {
      List<String> appliedNames = new ArrayList<>();

      for (String n : names) {
         appliedNames.add(fx.apply(n));
      }

      return appliedNames;
   }

   private static Employee maker(Supplier<Employee> fx) {
      return fx.get();
   }

   static class Employee {
      @Override
      public String toString() {
         return "A RANDOM EMPLOYEE";
      }
   }
}
