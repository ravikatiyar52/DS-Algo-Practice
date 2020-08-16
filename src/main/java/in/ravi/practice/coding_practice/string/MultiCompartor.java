/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 25-Nov-2019
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             25-Nov-2019         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.string;

import java.util.Comparator;

public class MultiCompartor implements Comparator<Object> {

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean compare(int a, int b) {
		// TODO Auto-generated method stub
		return a == b;
	}
	
	public boolean compare(String a, String b) {
		// TODO Auto-generated method stub
		return a.equals(b);
	}
	
	public boolean compare(int a[],int b[]) {
		boolean result = false;
		
		if(a.length == b.length) {
			boolean all_equals = true;
			
			for(int i = 0; i<a.length ;i++) {
				if( a[i] != b[i]) {
					all_equals =false;
					break;
				}
			}
			if (all_equals) {
				result = true;
			}
			
		}
		
		return result;
	}

}


