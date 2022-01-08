/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Assn3.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - main()
// TIME SPENT: 600 minutes
---------------------------------------*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/*
 * This class has the main() it receives the necessary values from the user to set up the dungeon and party
 */
public class Assn3 {
	
	public static void main(String[] args)
	{

		//Declare and instantiate Scanner in for user input
		Scanner in = new Scanner(System.in);
		
		//Declare and instantiate logic variables
		boolean welcomeInterface = true;
		boolean partySelection = true;
		int userInput;
		boolean randomDungeon = true;
		boolean randomParty = false;
		boolean completeRandom = true;
		int determinedLength = -1;
		
		//Declare adventure, but save the instantiation based on what the user chooses...
		Adventure adventure;
		
		//This is the main while loop that continues to bug the user for information until it gets what it needs (random dungeon or party and vice versa)
		while(welcomeInterface)
		{
			//loop the interface in case the user enters an invalid input
			welcomeInterface();
			
			//Make sure user enters in an integer
			if(in.hasNextInt())
			{
				
				userInput = in.nextInt();
				
				//option lets the user select the amount of rooms in the dungeon
				if(userInput == 1)
				{
					//If you still see this comment, it means that I did not get to guard this input, my apologies, please just enter a valid integer above 0 and it will work :)
					System.out.print("Please enter the number of chambers >> ");
					if(in.hasNextInt())
					{
						determinedLength = in.nextInt();
						welcomeInterface = false;
						randomDungeon = false;
					}
					else
					{
						System.out.println("\n[INVALID OPTION. PLEASE ENTER A VALID INTEGER]\n\n");
					}
					
					System.out.println("You are now entering a dungeon with " + determinedLength + " chambers...\n\n" );
				}
				
				//option picks a random amount of rooms for the user
				else if(userInput == 2)
				{
					System.out.println("You are now entering a dungeon with an unknown amount of chambers...\n\n");
					welcomeInterface = false;
					randomDungeon = true;
				}
				
				//Quit
				else if(userInput == -1)
				{
					System.out.println("You have left the Dungeon...");
					welcomeInterface = false;
					partySelection = false;
				}
				else
				{
					System.out.println("\n[INVALID OPTION. PLEASE ENTER A VALID OPTION]\n\n");
				}
			}
			else
			{
				System.out.println("\n[INVALID OPTION. PLEASE ENTER A VALID OPTION]\n\n");
				in.nextLine();
			}
		} //End of main while loop
		
		//this loop is the same as the previous, except that it is asking for the party options (random or standard)
		while(partySelection)
		{
			
			partySelection();
			
			//Makes sure user enters in an integer
			if(in.hasNextInt())
			{
				userInput = in.nextInt();
				
				//gives the user a standard party
				if(userInput == 1)
				{
					System.out.println("You have chosen the Standard Party of Heroes... [GOOD LUCK]\n\n");
					partySelection = false;
					randomParty = false;
				}
				
				//gives the user a random party
				else if(userInput == 2)
				{
					System.out.println("You have chosen a Random party of Heroes... [GOOD LUCK]\n\n");
					partySelection = false;
					randomParty = true;
				}

				//Quit
				else if(userInput == -1)
				{
					System.out.println("You have left the Dungeon...");
					partySelection = false;
				}
				else
				{
					System.out.println("\n[INVALID OPTION. PLEASE ENTER A VALID OPTION]\n\n");
				}
			}
			else
			{
				System.out.println("\n[INVALID OPTION. PLEASE ENTER A VALID OPTION]\n\n");
				in.nextLine();
			}
		} // end of the main party selection loop
		
		//these if statements will communicate with the adventure class based on what the user input and create a new Adventure object
		if(randomDungeon && !randomParty)
		{
			adventure = new Adventure();
		}
		else if(!randomDungeon && !randomParty)
		{
			adventure = new Adventure(determinedLength, randomParty);
		}
		else if(!randomDungeon && randomParty)
		{
			adventure = new Adventure(determinedLength, randomParty);
		}
		else
		{
			adventure = new Adventure(completeRandom);
		}
		
		//here is where the magic happens; the runAdventure method is called from the new adventure object we just created
		adventure.runAdventure();	
		
		
	}
	
	/*
	 * welcome and dungeonSelect interface for the user
	 */
	private static void welcomeInterface()
	{
		System.out.println("Welcome to the Dastardly Dungeon!");
		System.out.println("Would you like to:");
		System.out.println("1 - Determine the length of the Dungeon");
		System.out.println("2 - Run a random Dungeon");
		System.out.println("-1 - Exit");
	}
	
	/*
	 * partySelection interface for the user
	 */
	private static void partySelection()
	{
		System.out.println("Would you like:");
		System.out.println("1 - A standard party (Wizard, Rogue, Barbarian, Paladin)");
		System.out.println("2 - A random party");
		System.out.println("-1 - Exit");
	}

}
