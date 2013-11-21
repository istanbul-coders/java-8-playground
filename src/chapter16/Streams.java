package chapter16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0
 */
public class Streams {
   /**
    * Streams are not data-structures
    * Are intelligent
    * Can be operated in parallel
    * Can be unbounded
    */
   public static void main(String[] args) {
      // variadic args
      Stream<Integer> variadic = Stream.of(1, 2, 3, 4);

      // arrays
      Integer[] numbers = {1, 2, 3, 4};
      Stream<Integer> arrayStreams1 = Stream.of(numbers);
      Stream<Integer> arrayStreams2 = Arrays.stream(numbers);

      // list or collections
      List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
      Stream<Integer> listStream = numberList.stream();

      Set<Integer> numberSet = new HashSet<Integer>() {{
         add(1);
         add(2);
         add(3);
      }};
      Stream<Integer> collectionStream = numberSet.stream();

      // CAUTION

      int[] intArray = {1, 2, 3, 4};
      Stream<int[]> singleElementStream = Stream.of(intArray);

      // OUTPUTS

      System.out.println(Arrays.toString(variadic.toArray(Integer[]::new)));
      arrayStreams1.toArray(); // watch it, it is Object[]

      System.out.println(arrayStreams2.collect(Collectors.toList()));
   }
}
