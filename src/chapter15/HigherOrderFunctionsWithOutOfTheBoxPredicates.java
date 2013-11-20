package chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @version 1.0
 */
public class HigherOrderFunctionsWithOutOfTheBoxPredicates {
   public static void main(String[] args) {
      Predicate<Employee> isPaidEnough = e -> e.salary > 10_000;
      Predicate<Employee> isExperiencedEnough = e -> e.id < 10;

      List<Employee> employees = Arrays.asList(
            new Employee(1, 5_000, "John Doe"),
            new Employee(2, 85_000, "Jane Woo"),
            new Employee(15, 55_000, "Martin Luther King")
      );

      System.out.println(findEmployees(employees, isPaidEnough));
      System.out.println(findEmployees(employees, isExperiencedEnough));
      System.out.println(findEmployees(employees, isExperiencedEnough.and(isPaidEnough)));
      System.out.println(findEmployees(employees, isExperiencedEnough.or(isPaidEnough)));
      System.out.println(findEmployees(employees, isExperiencedEnough.negate()));

      Employee somebody = employees.get(0);
      System.out.println(findEmployees(employees, Predicate.<Employee>isEqual(somebody)));
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
