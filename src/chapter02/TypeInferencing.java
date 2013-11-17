/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package chapter02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 */
public class TypeInferencing {
   public static void main(String[] args) {
      Integer[] numbers = {1, 2, 3};

      // watch type inferences, no need to define Integer
      Arrays.sort(numbers, (i1, i2) -> i2 - i1);

      System.out.println(Arrays.toString(numbers));
   }

}
