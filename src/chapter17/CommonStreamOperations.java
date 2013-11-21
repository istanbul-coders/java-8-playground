package chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @version 1.0
 */
public class CommonStreamOperations {
   private static List<Employee> employees = Arrays.asList(
         new Employee(1, 10_000, "John Doe"),
         new Employee(4, 20_000, "Oliver Twist"),
         new Employee(99, 60_000, "Mark Twain"),
         new Employee(3, 1_000, "Martin Luther King"),
         new Employee(18, 5_500, "Bruce Lee"),
         new Employee(7, 22_000, "Anna Karanina")
   );

   private static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

   public static void main(String[] args) {
      doForEach();
      doMap();
      doFilter();
      doFindFirst();
      doOptional();
   }

   private static void doForEach() {
      // foreach can be parallel, and less verbose
      // however, you cannot break a stream, nor change a local variable (ref. variable scoping)

      // print all the employees
      heros().forEach(System.out::println);

      // print all the names
      heros().forEach(e -> System.out.println(e.name));
   }

   private static void doMap() {
      // produces another stream with the same size

      naturals().map(n -> n * n).forEach(System.out::println);
      naturals().map(Math::sqrt).forEach(System.out::println);
   }

   private static void doFilter() {
      // even numbers
      naturals().filter(n -> n % 2 == 0).forEach(System.out::println);

      // highly paid employees
      heros().filter(e -> e.salary > 20_000).forEach(System.out::println);
   }

   private static void doFindFirst() {
      // returns Optional
      // can do short-circuits
      Integer found1 = naturals().filter(n -> n % 2 == 0).findFirst().orElse(-1);
      Integer found2 = naturals().filter(n -> n > 99).findFirst().orElse(-1);

      System.out.println("found1 = " + found1);
      System.out.println("found2 = " + found2);
   }

   private static void doOptional() {
      // cannot create Optional.of(null)

      Optional<String> optional1 = Optional.empty();
      Optional<String> optional2 = Optional.of("DEMO");

      System.out.println("optional2.get = " + optional2.get());
      System.out.println("optional1.orElse = " + optional1.orElse("Something else"));
      optional2.ifPresent(System.out::println);
      System.out.println("optional1.isPresent = " + optional1.isPresent());
   }


   private static Stream<Employee> heros() {
      return employees.stream();
   }

   private static Stream<Integer> naturals() {
      return numbers.stream();
   }

   static class Employee {
      public int id;
      public double salary;
      public String name;

      Employee(int id, long salary, String name) {
         this.id = id;
         this.salary = salary;
         this.name = name;
      }

      @Override
      public String toString() {
         return id + ">" + name + ": " + salary;
      }
   }
}
