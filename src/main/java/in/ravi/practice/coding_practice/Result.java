/**
 * @author Ravi.Katiyar
 *
 * Creation Date : 31-May-2020
 * Copyright :InfoEdge Ltd
 * Description : Type description here
 * Program Specs Referred : -
 * 
 *
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * Revision:       Version      Last Revision Date         Name                Function/Module affected                            Modification Date
 * 
 * 0.0.1           0.0.0.1             31-May-2020         Ravi.Katiyar                  --  
 *             
 * -------------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * 
 */
package in.ravi.practice.coding_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

	/*
	 * Complete the 'getSelectionStatus' function below.
	 *
	 * The function is expected to return a 2D_STRING_ARRAY. The function accepts
	 * 2D_STRING_ARRAY applications as parameter.
	 */

		
		public enum PLAYER_TYPE {
			STRIKER,DEFENDER,BOTH
		}
		
		public static final String RESULT_STATUS_SELECTED = "SELECT";
		public static final String RESULT_STATUS_REJECTED = "REJECT";

		public static class FitnessFactor {
			private static final double MIN_HEIGHT = 5.8;
			private static final double MAX_BMI = 23;
			public static boolean isPlayerFit(double height, double BMI) {
				return height >= MIN_HEIGHT && BMI <= MAX_BMI;
			}
		}

		public static class StrikerExpFactor {
			private static final int MIN_GOALS_SCORED = 50;
			public static boolean isStriker(int goalsScored) {
				return goalsScored > MIN_GOALS_SCORED;
			}
		}

		public static class DefenderExpFactor {
			private static final int MIN_GOALS_DEFENDED = 30;
			public static boolean isDefender(int goalsDefended) {
				return goalsDefended > MIN_GOALS_DEFENDED;
			}
		}
		
		public static String[] isPlayerSelected(double playerHeight,double playerBMI,int goalsScored,int goalsDefended) {
			String [] selection = new String[2];
			boolean isStriker = false;
			boolean isDefender = false;
			PLAYER_TYPE playerType = null ;
			boolean playerFit = FitnessFactor.isPlayerFit(playerHeight, playerBMI) ;
			if(playerFit) {
				isStriker = StrikerExpFactor.isStriker(goalsScored);
				isDefender = DefenderExpFactor.isDefender(goalsDefended);
				if(isStriker && isDefender) {
					playerType = PLAYER_TYPE.BOTH;
				}else if(isStriker) {
					playerType = PLAYER_TYPE.STRIKER;
				}else if(isDefender) {
					playerType=PLAYER_TYPE.DEFENDER;
				}
			}
			if(playerType == null) {
				selection[0] = RESULT_STATUS_REJECTED;
				selection[1] = "NA";
			}else {
				selection[0] = RESULT_STATUS_SELECTED;
				selection[1] = playerType.name();
			}
			return selection;
		}
	

	public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
		
		int totalStrikers = 0;
		int totalDefenders = 0;
		int totalBoth = 0;
		
		List<List<String>> results = new ArrayList<List<String>>();
		Map<String, String[]> playerResultStatus = new HashMap<String, String[]>();
		
		
		for(List<String> application:applications) {
			String playerName = application.get(0);
			double playerHeight = Double.parseDouble(application.get(1));
			double playerBMI = Double.parseDouble(application.get(2));
			int goalsScored = Integer.parseInt(application.get(3));
			int goalsDefended = Integer.parseInt(application.get(4));
			String[] selectionResult = isPlayerSelected(playerHeight, playerBMI, goalsScored, goalsDefended);
			if(selectionResult[0] == RESULT_STATUS_SELECTED && PLAYER_TYPE.BOTH ==  PLAYER_TYPE.valueOf(selectionResult[1])) {
				totalBoth ++;
			}else if (selectionResult[0] == RESULT_STATUS_SELECTED && PLAYER_TYPE.STRIKER ==  PLAYER_TYPE.valueOf(selectionResult[1])) {
				totalStrikers ++;
			}else if (selectionResult[0] == RESULT_STATUS_SELECTED && PLAYER_TYPE.DEFENDER ==  PLAYER_TYPE.valueOf(selectionResult[1])) {
				totalDefenders ++;
			}
			playerResultStatus.put(playerName, selectionResult);
		}
		
		//equal number of strikers and defenders found
		if(totalStrikers == totalDefenders && totalBoth == 0 && totalStrikers > 0) {
			for(String playerName : playerResultStatus.keySet()) {
				String[] result = playerResultStatus.get(playerName);
				List<String> playerResult = new ArrayList<String>();
				playerResult.add(playerName);
				playerResult.add(result[0]);
				playerResult.add(result[1]);
				results.add(playerResult);
			}
		}
		
		return results;
		
	}

}
