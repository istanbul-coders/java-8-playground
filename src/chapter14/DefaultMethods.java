package chapter14;

/**
 * @version 1.0
 */
public class DefaultMethods {
   public static void main(String[] args) {
      // static methods
      CanFly.doSomethingStatic();

      // default methods
      CanFly flyer = new CanFly() {};
      flyer.doSomething();
   }

   interface CanFly {
      default void doSomething() {
         System.out.println("doing something...");
      }

      static void doSomethingStatic() {
         System.out.println("doing something static");
      }
   }

}
