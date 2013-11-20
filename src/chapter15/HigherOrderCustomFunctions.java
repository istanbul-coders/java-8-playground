package chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @version 1.0
 */
public class HigherOrderCustomFunctions {
   public static void main(String[] args) {
      List<Employee> employees = Arrays.asList(
            new Employee(1, 5_000, "John Doe"),
            new Employee(2, 85_000, "Jane Woo"),
            new Employee(15, 55_000, "Martin Luther King")
      );

      // with predicate
      System.out.println(findEmployees(employees, createCustomPredicateWith(10_000)));

      // with function definition, both are same
      Function<Double, Predicate<Employee>> customFunction = threshold -> (e -> e.salary > threshold);
      System.out.println(findEmployees(employees, customFunction.apply(10_000D)));
   }

   private static Predicate<Employee> createCustomPredicateWith(double threshold) {
      return e -> e.salary > threshold;
   }

   private static List<Employee> findEmployees(List<Employee> employees, Predicate<Employee> condition) {
      List<Employee> result = new ArrayList<>();

      for (Employee e : employees) {
         if (condition.test(e)) {
            result.add(e);
         }
      }

      return result;
   }

   static class Employee {
      public int id;
      public long salary;
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
