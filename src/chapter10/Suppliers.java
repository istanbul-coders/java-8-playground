package chapter10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @version 1.0
 */
public class Suppliers {
   public static void main(String[] args) {
      Supplier<Employee> employeeGenerator = Suppliers::employeeMaker;

      for (int i = 0; i < 10; i++) {
         System.out.println("Employee #" + i + ": " + employeeGenerator.get());
      }
   }

   public static Employee employeeMaker() {
      List<String> names = Arrays.asList("John Doe", "Jane Doe", "Mark Twain", "Oliver Twist", "Ferdinand IV");

      return new Employee(
            names.get((int) (Math.random() * names.size())),
            Math.random() * 20_000
      );
   }

   static class Employee {
      public String name;
      public double salary;

      Employee(String name, double salary) {
         this.name = name;
         this.salary = salary;
      }

      @Override
      public String toString() {
         return name + ": " + salary;
      }
   }
}
