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
		//System.out.println("Size: " + acronymList.size());
		//System.out.println(acronymList.get(0).toString());
	}
	
	public ArrayList<Acronym> getAcronymList()
	{
		return acronymList;
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
		int letterCount = 0;
		boolean validAcronym;
		char []charArray;
		ArrayList<ArrayList<String>> possibleWords;
	
		for(String word:wordList)
		{
			possibleWords = new ArrayList<ArrayList<String>>();
			
			for(int i = 0; i < word.length(); i++)
			{
				possibleWords.add(new ArrayList<String>());
			}
			
			charArray = word.toCharArray();
			
			for(int i = 0; i < word.length(); i++)
			{
				for(String s:possibleAcronyms)
				{
					if(s.charAt(0) == charArray[i])
					{
						possibleWords.get(i).add(s);
					}
				}
			}
			
			validAcronym = true;
			for(ArrayList<String> a:possibleWords) // Check if any wordLists are valid
			{
				if(a.size() == 0)
				{
					validAcronym = false;
				}
			}
			
			if(validAcronym)
			{
				for(int i = 0; i < charArray.length;i++)
				{
					letterCount = 0;
					for(int j = 0; j < charArray.length; j++)
					{
						if(charArray[j] == charArray[i])
						{
							letterCount++;
						}
					}
					if(letterCount > possibleWords.get(i).size())
					{
						validAcronym = false;
					}
				}
			}
			
			
			if(validAcronym)
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





