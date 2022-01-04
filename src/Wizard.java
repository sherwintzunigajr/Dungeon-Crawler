/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Wizard.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - Hero Child
// FOR: CSE 205- assignment3 - Justin Selgrad
// TIME SPENT: 60 minutes
---------------------------------------*/

/*
 * This is a child class with unique properties that inherits from Hero, contains everything that Hero has and more
 */
public class Wizard extends Hero {
	
	private final double MIN_ATTACK = 5.0;
	private final double MAX_ATTACK = 10.0;
	
	private final double MIN_DEFENSE = 0.1;
	private final double MAX_DEFENSE = 0.3;
	
	private final double HIT_POINT_MULTIPLIER = 0.35;
	
	public Wizard()
	{
		this.attack = attackGenerator(MIN_ATTACK, MAX_ATTACK);
		this.defense = defenseGenerator(MIN_DEFENSE, MAX_DEFENSE);
		this.hitPoints = (int)(this.hitPoints * 0.35);
	}
	
	@Override
	public int doAttack(float enemyDefense)
	{
		return (int)((2.0 * this.attack * enemyDefense) + 5.0);
	}
	
	@Override
	public int takeDamage(float enemyAttack)
	{
		this.hitPoints -= Math.ceil((enemyAttack * (1 - this.defense)));
		
		return (int)(Math.ceil((enemyAttack * (1 - this.defense))));
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
		return "Wizard\nAtt: " + this.attack + "\nDef: " + this.defense + "\nHitPoints: " + this.hitPoints;
	}
	
	public String getName()
	{
		return "Wizard";
	}

}
