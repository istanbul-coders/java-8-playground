package chapter06;

/**
 * @version 1.0
 */
public class MethodReferences {
   public static void main(String[] args) {
      doSomethingWithBelowInterface(Math::sin, 60);
   }

   public static void doSomethingWithBelowInterface(TakeDoubleReturnDouble iface, double x) {
      System.out.println("iface.exec(x) = " + iface.exec(x));
   }

   @FunctionalInterface
   interface TakeDoubleReturnDouble {
      double exec(double something);
   }

}
