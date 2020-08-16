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

class Result {

    /*
     * Complete the 'compressedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING message as parameter.
     */

    public static String compressedString(String message) {
    	


    	

    	    /*
    	     * Complete the 'compressedString' function below.
    	     *
    	     * The function is expected to return a STRING.
    	     * The function accepts STRING message as parameter.
    	     */

 
    	    String out ="";
    	    int sum = 1;
    	    char current = message.charAt(0);
    	    int count =1;
    	    StringBuilder result = new StringBuilder();
  
    	    for(int i=1;i<message.length();i++){
    	        if(message.charAt(i) == current){
    	            count ++;
    	        }else{
    	            if(count >1){
    	            result.append(current+""+count);
    	            }else{
    	                result.append(current);
    	            }
    	            current=message.charAt(i);
    	            count =1;
    	        }
    	    }
    	    if(count >1){
    	            result.append(current+""+count);
    	            }else{
    	                result.append(current);
    	            }
    	    return result.toString();

    	    }

    	

    	


    }


