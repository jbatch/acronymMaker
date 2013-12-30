import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AcronymMaker
{
	ArrayList<String> wordList, possibleAcronyms;
	ArrayList<Acronym> acroynmList;

	public AcronymMaker()
	{
		wordList = new ArrayList<String>();
		possibleAcronyms = new ArrayList<String>();
		acroynmList = new ArrayList<Acronym>();
	
		generatePossibleAcronyms();
		generateWordlist();
		findAcronyms();
	}
	
	private void generatePossibleAcronyms()
	{
		String word;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("bigot.txt"));
			while((word=br.readLine()) != null)
			{
				possibleAcronyms.add(word);
			}
			br.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private void generateWordlist()
	{
		String word;
	
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"));
			while((word=br.readLine()) != null)
			{
				if(word.length() >= 4 && word.length() <= 8)
				{
					wordList.add(word);
				}
			}
			br.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
	}
	
	private void findAcronyms()
	{
		boolean pass = false, wordFound = false;
		char []charArray;
		ArrayList<String> tempListRemaining, tempListAdded = new ArrayList<String>();
	
		for(String word:wordList)
		{
			tempListRemaining = possibleAcronyms;
			charArray = word.toCharArray();
			pass = false;
			for(int i = 0; i < word.length(); i++)
			{
				wordFound = false;
				for(String s:tempListRemaining)
				{
					if(s.charAt(0) == charArray[i])
					{
						wordFound = true;
						tempListRemaining.remove(s);
						tempListAdded.add(s);
					}
				}
			}
		}
	}
}
