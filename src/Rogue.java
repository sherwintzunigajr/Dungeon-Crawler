/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Rogue.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - Hero Child
// FOR: CSE 205- assignment3 - Justin Selgrad
// TIME SPENT: 60 minutes
---------------------------------------*/

/*
 * This is a child class with unique properties that inherits from Hero, contains everything that Hero has and more
 */
public class Rogue extends Hero {
	
	private final double MIN_ATTACK = 8.0;
	private final double MAX_ATTACK = 12.0;
	
	private final double MIN_DEFENSE = 0.4;
	private final double MAX_DEFENSE = 0.6;
	
	private final double HIT_POINT_MULTIPLIER = 0.6;
	
	public Rogue()
	{
		this.attack = attackGenerator(MIN_ATTACK, MAX_ATTACK);
		this.defense = defenseGenerator(MIN_DEFENSE, MAX_DEFENSE);
		this.hitPoints = (int)(this.hitPoints * 0.6);
	}
	
	@Override
	public int doAttack(float enemyDefense)
	{
		double critical = Math.random();
		
		if(critical < 0.2) { return (int)(this.attack * 2); }
		else { return (int)(this.attack); }
	}
	
	@Override
	public int takeDamage(float enemyAttack)
	{
		double dodge = Math.random();
		
		if(dodge < 0.2) 
		{ 
			this.hitPoints -= 0;
			return 0;
		}
		else 
		{ 
			this.hitPoints -= Math.ceil((enemyAttack * (1 - this.defense))); 
			return (int)(Math.ceil((enemyAttack * (1 - this.defense))));
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
		return "Rogue\nAtt: " + this.attack + "\nDef: " + this.defense + "\nHitPoints: " + this.hitPoints;
	}
	
	public String getName()
	{
		return "Rogue";
	}

}
