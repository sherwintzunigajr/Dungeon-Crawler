/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_HobGoblin.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - Enemy Child
// FOR: CSE 205- assignment3 - Justin Selgrad
// TIME SPENT: 60 minutes
---------------------------------------*/

public class HobGoblin extends Enemy {
	
	private final double MIN_DEFENSE_MODIFIER = 0.6;
	private final double MAX_DEFENSE_MODIFIER = 0.8;
	
	private final int MIN_ATTACK_MODIFIER = 12;
	private final int MAX_ATTACK_MODIFIER = 20;
	
	public HobGoblin()
	{
		this.defenseModifier = defenseModifierGenerator(MIN_DEFENSE_MODIFIER, MAX_DEFENSE_MODIFIER);
		this.attackModifier = attackModifierGenerator(MIN_ATTACK_MODIFIER, MAX_ATTACK_MODIFIER);
	}
	
	@Override
	public Enemy generateNeighbor()
	{
		double random = Math.random();
		
		if(random < 0.4) { return new HobGoblin(); }
		else if(random < 0.65) { return new Goblin(); }
		else if(random < 0.90) { return new Kobold(); }
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
	
	
	
	private float defenseModifierGenerator(double MIN_DEFENSE, double MAX_DEFENSE)
	{
		return (float) ((Math.random() * (MAX_DEFENSE - MIN_DEFENSE)) + MIN_DEFENSE);
	}
	
	private float attackModifierGenerator(int MIN_ATTACK, int MAX_ATTACK)
	{
		return (float) ((Math.random() * (MAX_ATTACK - MIN_ATTACK)) + MIN_ATTACK);
	}
	
	public String toString()
	{
		return "HobGoblin - " + this.hitPoints + " Hit-Points";
	}
	
	public String getName()
	{
		return "HobGoblin";
	}

}
