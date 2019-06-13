/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 10-Jun-2019
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             10-Jun-2019         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice.java.core;

import java.util.Comparator;

public class StudentComprator implements Comparator<Student> {

	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
