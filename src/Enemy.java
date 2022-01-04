/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Enemy.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - Enemy Abstract Class
// FOR: CSE 205- assignment3 - Justin Selgrad
// TIME SPENT: 30 minutes
---------------------------------------*/

/*
 * This class is merely for inheritance purposes for the 4 Enemy classes
 */
public abstract class Enemy {
	
	private final int MIN_HITPOINTS = 100;
	private final int MAX_HITPOINTS = 200;
	
	protected int hitPoints;
	protected float defenseModifier;
	protected float attackModifier;
	
	//this default constructor gives Enemies a set amount of hitPoints upon creation (between 100 and 200)
	public Enemy()
	{
		this.hitPoints = hitPointGenerator(MIN_HITPOINTS, MAX_HITPOINTS);
	}
	
	//abstract methods for the 4 enemy classes
	public abstract Enemy generateNeighbor();
	public abstract float takeDamage(float damageFromHero);
	public abstract float getAttack();
	public abstract float getDefense();
	public abstract String getName();
	
	//for RNG HP purposes
	private int hitPointGenerator(int MIN_HITPOINTS, int MAX_HITPOINTS)
	{
		return (int) ((Math.random() * (MAX_HITPOINTS - MIN_HITPOINTS)) + MIN_HITPOINTS);
	}
	
	
	

}
