/*
 * The cows and bulls game, Player A chooses a word and player B guesses a word. 
 * You say bulls when a character in the player B's guess match with a character 
 * in player A's word and also it is in the correct position as in A's word. You say cows, 
 * when a character in the player B's word match the character in player A, but it is not in the correct position.
 * The characters are case insensitive. Given two words player A's and player B's,Write a function that return
 * the number of bulls and no of cows. For example, 
 *   A - Picture B- Epic, bulls -0, cows - 4 
 *   A - forum B - four, bulls - 2 cows - 2
 */

import java.util.ArrayList;
import java.util.List;

public class CowsnBullsGame {

	/**
	 * o(n square)
	 * @param playerA
	 * @param playerB
	 */
	private static void findCowsandBulls(String playerA, String playerB){
		//if any of the strings are null, the game cannot be played
		if( playerA == null || playerB == null ) 
		{
			return;
		}

		int bulls = 0;
		int cows = 0;

		//for the string selected by player A
		for( int i = 0; i < playerA.length(); i++ )
		{
			char runnerChar = playerA.charAt(i);

			//run thru all the characters in word selected by player B
			for( int j = 0; j < playerB.length(); j++ )
			{
				char playerBChar = playerB.charAt(j);

				//character match - change to lower because case does not matter
				if( Character.toLowerCase(runnerChar) == Character.toLowerCase(playerBChar))
				{
					if( i == j )
					{ //position match
						bulls++;
					}
					else
					{ //contains relation
						cows++;
					}
				}
			}
		}

		System.out.println("Words: " + playerA + "," +  playerB + "; Bulls: " + bulls + ", Cows: " + cows);
	}

	/**
	 * o(m+n) //length of both the strings
	 * @param playerA
	 * @param playerB
	 */
	@SuppressWarnings("unchecked")
	private static void findCowsandBullsWithArray(String playerA, String playerB){
		//if any of the strings are null, the game cannot be played
		if( playerA == null || playerB == null ) return;

		int bulls = 0;
		int cows = 0;

		//put the string the array
		@SuppressWarnings("rawtypes")
		List playerBList = new ArrayList();
		for (char c : playerB.toCharArray()) {
			playerBList.add(Character.toLowerCase(c));
		}

		//for the string selected by player A
		for( int i = 0; i < playerA.length(); i++ ){
			char runnerChar = Character.toLowerCase(playerA.charAt(i));

			if( playerBList.contains(runnerChar)){
				if( playerBList.indexOf(runnerChar) == i){ //position match
					bulls++;
				}
				else{ 
					cows++;
				}
			}
		}

		System.out.println("Words: " + playerA + "," +  playerB + "; Bulls: " + bulls + ", Cows: " + cows);
	}

	public static void main(String[] args) {
		CowsnBullsGame.findCowsandBulls("forum", "four");
		CowsnBullsGame.findCowsandBulls("Picture", "epic");
		CowsnBullsGame.findCowsandBullsWithArray("forum", "four");
		CowsnBullsGame.findCowsandBullsWithArray("Picture", "epic");
	}

}