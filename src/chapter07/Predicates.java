package chapter07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @version 1.0
 */
public class Predicates {
   public static void main(String[] args) {
      List<Integer> numbers = Arrays.asList(1, 7, 3, 11);
      List<String> names = Arrays.asList("John", "Jane", "Max", "Katherine");

      List<Integer> filteredNumbers = filterIt(numbers, x -> x > 5);
      System.out.println("filteredNumbers = " + filteredNumbers);

      List<String> filteredNames = filterIt(names, x -> x.length() > 3);
      System.out.println("filteredNames = " + filteredNames);
   }

   public static <T> List<T> filterIt(List<T> candidates, Predicate<T> condition) {
      List<T> filteredList = new ArrayList<>();

      for(T candidate : candidates) {
         if (condition.test(candidate)) {
            filteredList.add(candidate);
         }
      }

      return filteredList;
   }
}
