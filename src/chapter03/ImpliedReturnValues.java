/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package chapter03;

import java.util.Arrays;

/**
 * @version 1.0
 */
public class ImpliedReturnValues {
   public static void main(String[] args) {
      Integer[] numbers = {1, 2, 3};

      // watch return types, it is implied, no return keyword is necessary
      Arrays.sort(numbers, (i1, i2) -> i2 - i1);

      System.out.println(Arrays.toString(numbers));
   }

}
