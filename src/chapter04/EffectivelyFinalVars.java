/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package chapter04;

import java.util.function.IntUnaryOperator;

/**
 * @version 1.0
 */
public class EffectivelyFinalVars {
   public static void main(String[] args) {
      final Integer number1 = 20;
      Integer number2 = 10;

      MessagePrinter printer = new MessagePrinter() {
         @Override
         public void print() {
            // has to be final
            System.out.println("number1 = " + number1);
         }
      };

      // watch here, we accessed number2 and it's not final inside a lambda
      incrementEffectivelyFinalVar(x -> x + number2);

   }

   public static void incrementEffectivelyFinalVar(IntUnaryOperator operator) {
      System.out.println("operator.applyAsInt(1) = " + operator.applyAsInt(1));
   }

   interface MessagePrinter {
      void print();
   }
}
