/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Hero.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - Hero Abstract Class 
// FOR: CSE 205- assignment3 - Justin Selgrad
// TIME SPENT: 30 minutes
---------------------------------------*/

/*
 * This class is merely for inheritance purposes for the 4 hero classes
 */
public abstract class Hero {
	
	private final int MIN_HIT_POINTS = 50;
	private final int MAX_HIT_POINTS = 100;
	
	protected int hitPoints;
	protected float attack;
	protected float defense;
	
	//This default constructor passes a set amount of hitPoints to each hero upon creation (between 50 and 100)
	public Hero()
	{
		this.hitPoints = hitPointGenerator(MIN_HIT_POINTS, MAX_HIT_POINTS);
	}
	
	//getters
	public int getHitPoints()
	{
		return this.hitPoints;
	}
	
	public float getAttack()
	{
		return this.attack;
	}
	
	public float getDefense()
	{
		return this.defense;
	}
	
	//abstract methods allow for specialized behavior in the child classes. these must be overridden
	public abstract int doAttack(float enemyDefense);
	public abstract int takeDamage(float enemyAttack);
	public abstract String getName();
	
	//for RNG HP purposes
	private int hitPointGenerator(int MIN_HIT_POINTS, int MAX_HIT_POINTS)
	{
		return (int) ((Math.random() * (MAX_HIT_POINTS - MIN_HIT_POINTS)) + MIN_HIT_POINTS);
	}

}
