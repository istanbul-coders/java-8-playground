/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package chapter11;

import java.util.function.BinaryOperator;

/**
 * @version 1.0
 */
public class BinaryOperators {
   public static void main(String[] args) {
      BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;

      System.out.println(adder.apply(3, 4));
   }
}
