/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 13-Jan-2020
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             13-Jan-2020         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice;

import java.io.*;
import java.util.*;
public class TestClass {
    public static void main(String[] args) throws IOException {
    	
    	int array1 [] = {1,2,3,4};
    	int array2 [] = {5,6,7,8};
    	int [] output = mergeArrays(array1, array2);
    	
    	for(int element : output)
    	System.out.print(element + " ");
    	
    }
    
    
    public static int[] mergeArrays(int a[],int b[]) {
    	
    	int count = 0;
    	int i =0;
    	int j=0;
    	int lastPushed = 2;
    	int[] finalArray = new int [a.length + b.length];
    	while( i < a.length && j < b.length) {
    		
    		if(lastPushed == 2)  {
    		finalArray[count++]	= a[i++];
    		lastPushed = 1;
    		}
    		else {
    			finalArray[count++]	= b[j++];
    			lastPushed = 2;
    		}
    		
    	}
    	return finalArray;
    	
    }
    static void query1(int N, int[] A, int L, int R, int V){
        for(int i = L ; i <= R; i ++) {
            A[i] = A[i] + V;
        }
        return;
    }
    static long query2(int N, int[] A, int L, int R) {
        long sum = 0;
        for(int i = L-1 ; i <= R-1; i ++) {
            sum = (long) (sum + Math.ceil(A[i]/5.0));
        }
        return sum;
    }
}







