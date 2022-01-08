/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Adventure.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - runs the game
// TIME SPENT: too much
---------------------------------------*/

import java.util.Arrays;
import java.util.Scanner;

/*
 * This class is where the game logic happens
 */
public class Adventure {
	
	private final int MIN_ROOM = 10;
	private final int MAX_ROOM = 50;
	
	private Enemy[] dungeon;
	private Hero[] party;
	private int heroCount;
	
	//Default constructor will have a random dungeon with standard party
	public Adventure()
	{
		int randomRoomAmount = randomDungeon(MIN_ROOM, MAX_ROOM);
		
		this.dungeon = new Enemy[randomRoomAmount];
		this.dungeon[0] = randomEnemy();
		
		for(int i = 1; i < this.dungeon.length; i++)
		{
			this.dungeon[i] = this.dungeon[i-1].generateNeighbor();
		}
		
		this.party = standardParty();
		this.heroCount = 4;
		
	}
	
	//overloaded constructor with selectSizeDungeon and random or standard party
	public Adventure(int dungeonLength, boolean randomParty)
	{
		this.dungeon = new Enemy[dungeonLength];
		this.dungeon[0] = randomEnemy();
		
		for(int i = 1; i < this.dungeon.length; i++)
		{
			this.dungeon[i] = this.dungeon[i-1].generateNeighbor();
		}
		
		if(randomParty)
		{
			this.party = randomParty();
			this.heroCount = 4;
		}
		else
		{
			this.party = standardParty();
			this.heroCount = 4;
		}
		
	}
	
	//overloaded constructor with completely random gen
	public Adventure(boolean completeRandom)
	{
		int randomRoomAmount = randomDungeon(MIN_ROOM, MAX_ROOM);
		
		this.dungeon = new Enemy[randomRoomAmount];
		this.dungeon[0] = randomEnemy();
		
		for(int i = 1; i < this.dungeon.length; i++)
		{
			this.dungeon[i] = this.dungeon[i-1].generateNeighbor();
		}
		
		this.party = randomParty();
		this.heroCount = 4;
	}
	
	/*
	 * This is the main body of the game logic, interfaces, etc
	 */
	public void runAdventure()
	{
		
		Scanner in = new Scanner(System.in);
		
		int userInput;
		int dungeonRoomCounter = 1;
		int round = 1;
		Enemy currentEnemy;
		boolean partyAlive = true;
		
		float heroDamage;
		float enemyDamage;
		
		//while the party still has heroes that are still alive and while you are still in the dungeon
		while(partyAlive && dungeonRoomCounter <= this.dungeon.length)
		{
			//sets the current enemy and room
			currentEnemy = this.dungeon[dungeonRoomCounter - 1];
			roundInterface(dungeonRoomCounter, currentEnemy, round);
			
			
			
			if(in.hasNextInt())
			{
				userInput = in.nextInt();
				
				//hero 1 attack
				if(userInput == 1)
				{
					if(this.party[0].getHitPoints() > 0)
					{
					heroDamage = currentEnemy.takeDamage(this.party[0].doAttack(currentEnemy.getDefense()));
					enemyDamage = this.party[0].takeDamage(currentEnemy.getAttack());
					
					System.out.println();
					System.out.println(this.party[0].getName() + " attacks and does " + heroDamage +  " Damage\n\n");
					System.out.println("The " + currentEnemy.getName() + " attacks and does " + enemyDamage +  " Damage\n\n");
					round++;
					}
					else
					{
						System.out.println("\n[THIS HERO IS DEAD. PLEASE CHOOSE ANOTHER HERO]\n\n");
					}
				}
				
				//hero 2 attack
				else if(userInput == 2)
				{
					if(this.party[1].getHitPoints() > 0)
					{
					heroDamage = currentEnemy.takeDamage(this.party[1].doAttack(currentEnemy.getDefense()));
					enemyDamage = this.party[1].takeDamage(currentEnemy.getAttack());
					
					System.out.println();
					System.out.println(this.party[1].getName() + " attacks and does " + heroDamage + " Damage\n\n");
					System.out.println("The " + currentEnemy.getName() + " attacks and does " + enemyDamage +  " Damage\n\n");
					
					round++;
					}
					else
					{
						System.out.println("\n[THIS HERO IS DEAD. PLEASE CHOOSE ANOTHER HERO]\n\n");
					}
				}

				//hero 3 attack
				else if(userInput == 3)
				{
					if(this.party[2].getHitPoints() > 0)
					{
					heroDamage = currentEnemy.takeDamage(this.party[2].doAttack(currentEnemy.getDefense()));
					enemyDamage = this.party[2].takeDamage(currentEnemy.getAttack());
					
					System.out.println();
					System.out.println(this.party[2].getName() + " attacks and does " + heroDamage + " Damage\n\n");
					System.out.println("The " + currentEnemy.getName() + " attacks and does " + enemyDamage +  " Damage\n\n");
					
					round++;
					}
					else
					{
						System.out.println("\n[THIS HERO IS DEAD. PLEASE CHOOSE ANOTHER HERO]\n\n");
					}
				}
				
				//hero 4 attack
				else if(userInput == 4)
				{
					if(this.party[3].getHitPoints() > 0)
					{
					heroDamage = currentEnemy.takeDamage(this.party[3].doAttack(currentEnemy.getDefense()));
					enemyDamage = this.party[3].takeDamage(currentEnemy.getAttack());
					
					System.out.println();
					System.out.println(this.party[3].getName() + " attacks and does " + heroDamage + " Damage\n\n");
					System.out.println("The " + currentEnemy.getName() + " attacks and does " + enemyDamage +  " Damage\n\n");
					
					round++;
					}
					else
					{
						System.out.println("\n[THIS HERO IS DEAD. PLEASE CHOOSE ANOTHER HERO]\n\n");
					}
					
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
			
			
			//if the current enemy dies, advance the room number and check for dead heroes to revive after the enemy is defeated
			if(currentEnemy.hitPoints <= 0)
			{
				dungeonRoomCounter++;
				
				if(this.party[0].getHitPoints() <= 0)
				{
					
					this.heroCount--;
					addHero(0);
				}
				else if(this.party[1].getHitPoints() <= 0)
				{
					
					this.heroCount--;
					addHero(1);
				}
				else if(this.party[2].getHitPoints() <= 0)
				{
					
					this.heroCount--;
					addHero(2);
				}
				else if(this.party[3].getHitPoints() <= 0)
				{
					
					this.heroCount--;
					addHero(3);
				}	
			}
			
			//if all heroes in the party are dead, end the game
			if(this.party[0].getHitPoints() <= 0 && this.party[1].getHitPoints() <= 0 && this.party[2].getHitPoints() <= 0 && this.party[3].getHitPoints() <= 0)
			{
				partyAlive = false;
			}
				
			//decrement heroCount for revival logic
			if(this.party[0].getHitPoints() <= 0) { heroCount--; }
			if(this.party[1].getHitPoints() <= 0) { heroCount--; }
			if(this.party[2].getHitPoints() <= 0) { heroCount--; }
			if(this.party[3].getHitPoints() <= 0) { heroCount--; }
			
			//in.close();
				
			
		}// end of game (while loop)
		
		//if partyAlive is still true, the game is won, else you lose
		if(partyAlive)
		{
			System.out.println("[CONGRATULATIONS! YOU MADE IT OUT OF THE DUNGEON! YOU WIN!]");
		}
		else
		{
			System.out.println("[ALL OF YOUR HEROES WERE DEFEATED! YOU LOSE!]");
		}
	
		
	}
	
	/*
	 * displays information for user
	 */
	private void roundInterface(int room, Enemy currentEnemy, int round)
	{
		System.out.println("Room#" + room + " has:");
		System.out.println(currentEnemy);
		System.out.println();
		System.out.println("Party:");
		
		for(int i = 1; i <= this.party.length; i++)
		{
			System.out.println("Hero #" + i );
			System.out.println(this.party[i - 1]);
			System.out.println();
		}
		
		System.out.println("Round #" + round);
		System.out.print("Which Hero will engage in Combat? >> ");
	}
	
	/*
	 * addHero will scan for a party that is missing heroes and add after an enemy is defeated
	 */
	private void addHero(int deadHeroIndex)
	{
		if(this.heroCount < 4)
		{
			this.heroCount++;
			
			this.party[deadHeroIndex] = randomHero();
		}
	}
	
	/*
	 * random dungeon generator
	 */
	private int randomDungeon(int MIN_ROOM, int MAX_ROOM)
	{
		return (int)((Math.random() * (MAX_ROOM - MIN_ROOM))+ MIN_ROOM);
	}
	
	/*
	 * random enenmy at start room
	 */
	private Enemy randomEnemy()
	{
		double random = Math.random();
		
		if(random < 0.25) { return new Goblin(); }
		else if(random < 0.50) { return new HobGoblin(); }
		else if(random < 0.75) { return new Kobold(); }
		else { return new LizardFolk(); }
	}
	
	/*
	 * random hero for revival 
	 */
	private Hero randomHero()
	{
		double random = Math.random();
		
		if(random < 0.25) { return new Wizard(); }
		else if(random < 0.50) { return new Rogue(); }
		else if(random < 0.75) { return new Barbarian(); }
		else { return new Paladin(); }
	}
	
	/*
	 * standard party
	 */
	private Hero[] standardParty()
	{
		Hero[] standardParty = new Hero[4];
		
		standardParty[0] = new Wizard();
		standardParty[1] = new Rogue();
		standardParty[2] = new Barbarian();
		standardParty[3] = new Paladin();
		
		return standardParty;
	}
	
	/*
	 * random party
	 */
	private Hero[] randomParty()
	{
		Hero[] randomParty = new Hero[4];
		
		for(int i = 0; i < randomParty.length; i++)
		{
			double random = Math.random();
			
			if(random < 0.25) { randomParty[i] = new Wizard(); }
			else if(random < 0.50) { randomParty[i] = new Rogue(); }
			else if(random < 0.75) { randomParty[i] = new Barbarian(); }
			else { randomParty[i] = new Paladin(); }
		}
		
		return randomParty;
		
	}

}
