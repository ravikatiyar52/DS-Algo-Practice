/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 12-Apr-2019
 * This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

 * 
 */
package in.ravi.practice.coding_practice.daily_problems;

import java.util.HashSet;
import java.util.Set;

public class Autocomplete_day11 {

	public static Set<String> getSuggetions(Set<String> completeSet, String queryString) {

		Set<String> suggetions = new HashSet<String>();

		for (String s : completeSet) {
			if (s.startsWith(queryString)) {
				suggetions.add(s);
			}
		}

		return suggetions;
	}

	public static void main(String args[]) {

		Set<String> completeSet = new HashSet<String>();
		completeSet.add("dog");
		completeSet.add("deer");
		completeSet.add("deal");

		Set<String> suggetions = getSuggetions(completeSet, "de");

		for (String s : suggetions) {
			System.out.println(s);
		}
	}

}
