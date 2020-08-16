/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 07-Jan-2020
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             07-Jan-2020         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.java.core;

public class ObjectReferenceExample {

	static Simpson simpson = new Simpson();
	static Simpson simpson2 = new Simpson();
	
	public static void main(String... doYourBest) {
		
		simpson.name= "name1";
		//System.out.println("inside main " + simpson);
		transformIntoHomer(simpson);
		//System.out.println("inside main after func call" + simpson);
		System.out.println(simpson.name);
	}

	static void transformIntoHomer(Simpson simpson) {
		
	
		simpson2.name = "name2";
		//System.out.println("simson 2 " + simpson2);
		simpson = simpson2;
		//System.out.println("" + simpson.name);
	}

}

class Simpson {
	String name;
}
