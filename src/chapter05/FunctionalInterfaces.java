/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package chapter05;

/**
 * @version 1.0
 */
public class FunctionalInterfaces {
   public static void main(String[] args) {
      // function that its area to be integrated
      Integratable fx = x -> x * x + 1;

      for (int i = 0; i < 5; i++) {
         // more slices will make it more accurate
         int numberOfSlices = (int) Math.pow(10, i);
         double result = integrate(fx, 1, 10, numberOfSlices);

         System.out.println("result = " + result);
      }
   }

   public static double integrate(Integratable fx, double x1, double x2, int numberOfSlices) {
      double sum = 0D;

      double delta = (x2 - x1) / numberOfSlices;
      double start = x1 + (delta / 2);

      for (int i = 0; i < numberOfSlices; i++) {
         sum += delta * fx.eval(start + delta * i);
      }

      return sum;
   }

   @FunctionalInterface
   interface Integratable {
      double eval(double x);
   }
}
