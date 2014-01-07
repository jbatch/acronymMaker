import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AcronymMaker
{
	ArrayList<String> wordList, possibleAcronyms;
	ArrayList<Acronym> acronymList;

	public AcronymMaker()
	{
		wordList = new ArrayList<String>();
		possibleAcronyms = new ArrayList<String>();
		acronymList = new ArrayList<Acronym>();
	
		generatePossibleAcronyms();
		generateWordlist();
		findAcronyms();
		//printWordList(possibleAcronyms);
		System.out.println("Size: " + acronymList.size());
		System.out.println(acronymList.get(0).toString());
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
		boolean pass = false, wordFound = false, fullAcronym;
		char []charArray;
		ArrayList<ArrayList<String>> possibleWords;
		ArrayList<String> tempListRemaining, tempListAdded = new ArrayList<String>();
		int wordsAdded;
	
		for(String word:wordList)
		{
			
			wordsAdded = 0;
			possibleWords = new ArrayList<ArrayList<String>>();
			
			for(int i = 0; i < word.length(); i++)
			{
				possibleWords.add(new ArrayList<String>());
			}
			
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
						wordsAdded++;
						//tempListAdded.add(s);
						possibleWords.get(i).add(s);
						//System.out.println("Word: " + word + " i: " + i + " s:" + s);
					}
				}
	
				
			}
			
			fullAcronym = true;
			for(ArrayList<String> a:possibleWords) // Check if any wordLists have no words added
			{
				if(a.size() == 0)
				{
					fullAcronym = false;
				}
			}
			
			if(fullAcronym)
			{
				acronymList.add(new Acronym(word, possibleWords));
			}
	
		}
	}
	
	private void printWordList(ArrayList<String> list)
	{
		for(String s:list)
		{
			System.out.println(s);
		}
	}
}





