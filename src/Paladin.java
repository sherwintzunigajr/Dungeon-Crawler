/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Paladin.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - Hero Child
// FOR: CSE 205- assignment3 - Justin Selgrad
// TIME SPENT: 60 minutes
---------------------------------------*/

/*
 * This is a child class with unique properties that inherits from Hero, contains everything that Hero has and more
 */
public class Paladin extends Hero {
	
	private final double MIN_ATTACK = 4.0;
	private final double MAX_ATTACK = 8.0;
	
	private final double MIN_DEFENSE = 0.7;
	private final double MAX_DEFENSE = 0.95;
	
	private final double HIT_POINT_MULTIPLIER = 1;
	
	public Paladin()
	{
		this.attack = attackGenerator(MIN_ATTACK, MAX_ATTACK);
		this.defense = defenseGenerator(MIN_DEFENSE, MAX_DEFENSE);
	}
	
	@Override
	public int doAttack(float enemyDefense)
	{
		return (int)((this.attack * enemyDefense) + (0.5 * this.attack));
	}
	
	@Override
	public int takeDamage(float enemyAttack)
	{
		if(enemyAttack > 5.0)
		{
			double divide = Math.random();
			
			if(divide < 0.2) 
			{ 
				this.hitPoints -= Math.ceil(enemyAttack / 2.0);
				return (int)(Math.ceil((enemyAttack / 2.0)));
			}
			else 
			{ 
				this.hitPoints -= Math.ceil((enemyAttack * (1 - this.defense)));
				return (int)(Math.ceil((enemyAttack * (1 - this.defense))));
			}
		}
		else
		{
			this.hitPoints -= (enemyAttack * (1 - this.defense));
			return (int)(enemyAttack * (1 - this.defense));
		}
	}
	
	
	
	
	private float attackGenerator(double MIN_ATTACK, double MAX_ATTACK)
	{
		return (float) ((Math.random() * (MAX_ATTACK - MIN_ATTACK)) + MIN_ATTACK);
	}
	
	private float defenseGenerator(double MIN_DEFENSE, double MAX_DEFENSE)
	{
		return (float) ((Math.random() * (MAX_DEFENSE - MIN_DEFENSE)) + MIN_DEFENSE);
	}
	
	public String toString()
	{
		return "Paladin\nAtt: " + this.attack + "\nDef: " + this.defense + "\nHitPoints: " + this.hitPoints;
	}

	public String getName()
	{
		return "Paladin";
	}
}
