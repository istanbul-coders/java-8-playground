package chapter15;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0
 */
public class HigherOrderFunctionsWithOutOfTheBoxConsumers {
   public static void main(String[] args) {
      List<Employee> employees = Arrays.asList(
            new Employee(1, 5_000, "John Doe"),
            new Employee(2, 85_000, "Jane Woo"),
            new Employee(15, 55_000, "Martin Luther King")
      );

      Consumer<Employee> raiser = e -> {
         e.salary = e.salary * 1.1;
      };

      raiseEmployees(employees, System.out::println);
      raiseEmployees(employees, raiser.andThen(System.out::println));
   }

   private static void raiseEmployees(List<Employee> employees, Consumer<Employee> fx) {
      for (Employee e : employees) {
         fx.accept(e);
      }
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
