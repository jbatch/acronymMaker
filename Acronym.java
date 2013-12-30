import java.util.ArrayList;

public class Acronym
{
	String acronym;
	ArrayList<String> words;
	
	public Acronym(String acronym, ArrayList<String> words)
	{
		this.acronym = acronym;
		this.words = words;
	}
	
	public String getAcronym()
	{return acronym;}
	public ArrayList<String> getWords()
	{return words;}
	
	
}
