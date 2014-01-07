import java.io.IOException;
import java.util.ArrayList;

public class AcronymMenu
{
	AcronymMaker acronymMaker;
	ArrayList<Acronym> acronymList;

	public AcronymMenu()
	{
		acronymMaker = new AcronymMaker();
		acronymList = acronymMaker.getAcronymList();
		System.out.println("Welcome to Acronym Maker\n");
		startMenuLoop();
	}
	
	private void startMenuLoop()
	{
		boolean exit = false;
		while(!exit)
		{
			try
			{
				displayMainMenu();
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void displayMainMenu() throws IOException
	{
		int i;
		System.out.println("===============\n1. Load list of acronyms\n2. View acronym\n3. Show random acronym\n4. Exit\n===============");
		i = ConsoleIO.readInt();
		displayAction(i);
	}
	
	private void displayAction(int i)
	{
		switch(i)
		{
			case 1:	printAcronyms();
						break;
			case 2: 	viewAcronym();
						break;
			case 3:	printRandomAcronym();
						break;
			case 4: 	System.exit(0);
						break;
			default: break;
		}
	}
	
	private void printAcronyms()
	{
		for(Acronym a:acronymList)
		{
			System.out.println(a.getAcronym().toUpperCase());
		}
	}
	
	private void viewAcronym()
	{
		String s = new String("");
		boolean acronymFound = false;
		
		System.out.println("Enter acronym to display: ");
		try
		{
			s = ConsoleIO.readLine();
			for(Acronym a: acronymList)
			{
				if(s.toUpperCase().equals(a.getAcronym().toUpperCase()))
				{
					System.out.println(a.toString());
					acronymFound = true;
				}
			}
			if(!acronymFound)
			{
				throw new IllegalArgumentException("Acronym \"" + s.toUpperCase() + "\" not found");
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e2)
		{
			System.out.println(e2.getMessage());
		}
	}
	
	private void printRandomAcronym()
	{
		int r = 0 + (int)(Math.random() * ((acronymList.size() - 0) + 1));
		System.out.println(acronymList.get(r).toString());
	}
}
