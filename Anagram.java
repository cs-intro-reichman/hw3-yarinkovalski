/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) 
	{
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and check " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) 
	{
		int ind3;
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		for (int ind1 = 0; ind1 < str1.length();ind1++)
		{
			while (str2.length()>0) 
			{
				ind3 = str2.indexOf(str1.charAt(ind1)); 
				if (ind3 == -1)
					return false;
				else
				{
					str2 = str2.substring(0,ind3) + str2.substring(ind3+1);
					break;
				}
        	}
		}
		return true;
		// Replace the following statement with your code

		
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) 
	{
		str = str.toLowerCase();
		String n = "";
		for (int i=0; i<=str.length()-1; i++)
		{
			char signOrLetter = str.charAt(i);
			boolean find = false;
			for (int j=33; j<=64; j++)
			{
				if (signOrLetter == j)
				{
					find = true;
				}
			}
			if (find==false)
			{
				n = n+str.charAt(i);
			}
		}
		// Replace the following statement with your code
		return n;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) 
	{
		String str2 = "";
		while (str.length()>0) 
		{
			int max = str.length()-1;
			int min = 0;
			int	letterPlace = (int) (Math.random() * ((max-min)+1))+min;
			char letter = str.charAt(letterPlace);
			str2 = str2 + letter;
			str = str.substring(0, letterPlace) + str.substring(letterPlace+1);
		}
		return str2;
	}
}
