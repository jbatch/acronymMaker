import java.util.ArrayList;

public class Acronym
{
	String acronym;
	ArrayList<ArrayList<String>> words;
	
	public Acronym(String acronym, ArrayList<ArrayList<String>> words)
	{
		this.acronym = acronym;
		this.words = words;
	}
	
	public String getAcronym()
	{
		return acronym;
	}
	
	public ArrayList<ArrayList<String>> getWords()
	{
		return words;
	}
	
	public String toString()
	{
		char []charArray = acronym.toUpperCase().toCharArray();
		String returnString = new String("");
		for(int i = 0; i < acronym.length();i++)
		{
			returnString += charArray[i];
			for(int j = 0; j < words.get(i).size();j++)
			{
				returnString += " " + words.get(i).get(j);
			}
			returnString += "\n";
		}
		//return new String(String.format("Word: %s Word1: %s", acronym, words.get(0).get(0)));
		return returnString;
	}
	
	
}
