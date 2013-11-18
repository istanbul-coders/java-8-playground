package chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @version 1.0
 */
public class Functions {
   public static void main(String[] args) {
      List<Integer> numbers = Arrays.asList(1, 2, 3);

      // accepting integer, returning double
      System.out.println(mapIt(numbers, x -> Math.pow(10, x)));
   }

   public static <T, R> List<R> mapIt(List<T> candidates, Function<T, R> mapper) {
      List<R> mappedList = new ArrayList<>();

      for(T candidate : candidates) {
         mappedList.add(mapper.apply(candidate));
      }

      return mappedList;
   }
}
