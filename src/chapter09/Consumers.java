/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package chapter09;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0
 */
public class Consumers {
   public static void main(String[] args) {
      List<Employee> employees = Arrays.asList(
            new Employee("John Doe", 22_000),
            new Employee("Mark Twain", 11_000)
      );

      acceptAllEmployee(employees, e -> System.out.println(e.name));
      acceptAllEmployee(employees, e -> {
         e.salary *= 1.5;
      });
      acceptAllEmployee(employees, e -> System.out.println(e.name + ": " + e.salary));
   }

   public static void acceptAllEmployee(List<Employee> employees, Consumer<Employee> printer) {
      for (Employee e : employees) {
         printer.accept(e);
      }
   }

   static class Employee {
      public String name;
      public double salary;

      Employee(String name, double salary) {
         this.name = name;
         this.salary = salary;
      }
   }
}
