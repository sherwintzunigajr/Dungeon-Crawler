/*------------------------------------------------------------
// AUTHOR: Sherwin T Zuniga Jr
// FILENAME: Zuniga_Sherwin_Kobold.java
// SPECIFICATION: Dungeon Crawler OOP Polymorphism - Enemy Child
// TIME SPENT: 60 minutes
---------------------------------------*/

public class Kobold extends Enemy {
	
	private final double MIN_DEFENSE_MODIFIER = 0.3;
	private final double MAX_DEFENSE_MODIFIER = 0.6;
	
	private final int MIN_ATTACK_MODIFIER = 3;
	private final int MAX_ATTACK_MODIFIER = 15;
	
	public Kobold()
	{
		this.defenseModifier = defenseModifierGenerator(MIN_DEFENSE_MODIFIER, MAX_DEFENSE_MODIFIER);
		this.attackModifier = attackModifierGenerator(MIN_ATTACK_MODIFIER, MAX_ATTACK_MODIFIER);
	}
	
	@Override
	public Enemy generateNeighbor()
	{
		double random = Math.random();
		
		if(random < 0.5) { return new Kobold(); }
		else if(random < 0.85) { return new LizardFolk(); }
		else if(random < 0.95) { return new HobGoblin(); }
		else { return new Goblin(); }	
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
		return "Kobold - " + this.hitPoints + " Hit-Points";
	}
	
	public String getName()
	{
		return "Kobold";
	}

}
