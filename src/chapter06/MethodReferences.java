/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

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
