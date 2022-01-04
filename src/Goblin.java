/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Goblin.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - Enemy Child
// FOR: CSE 205- assignment3 - Justin Selgrad
// TIME SPENT: 60 minutes
---------------------------------------*/

public class Goblin extends Enemy {
	
	private final float MIN_ATTACK_MODIFIER = 6;
	private final float MAX_ATTACK_MODIFIER = 12;
	

	public Goblin()
	{
		this.defenseModifier = (float) 1.0;
		this.attackModifier = attackModifierGenerator(MIN_ATTACK_MODIFIER, MAX_ATTACK_MODIFIER);
	}
	
	@Override
	public Enemy generateNeighbor()
	{
		double random = Math.random();
		
		if(random < 0.6) { return new Goblin(); }
		else if(random < 0.85) { return new HobGoblin(); }
		else if(random < 0.95) { return new Kobold(); }
		else { return new LizardFolk(); }
	}
	
	@Override
	public float takeDamage(float damageFromHero)
	{
		this.hitPoints = (int)(this.hitPoints - damageFromHero);
		return damageFromHero;
	}
	
	@Override
	public float getAttack()
	{
		return this.attackModifier;
	}
	
	@Override
	public float getDefense()
	{
		return this.defenseModifier;
	}
	
	
	
	private float attackModifierGenerator(float MIN_ATTACK, float MAX_ATTACK)
	{
		return (float) ((Math.random() * (MAX_ATTACK - MIN_ATTACK)) + MIN_ATTACK);
	}
	
	public String toString()
	{
		return "Goblin - " + this.hitPoints + " Hit-Points";
	}
	
	public String getName()
	{
		return "Goblin";
	}
}
