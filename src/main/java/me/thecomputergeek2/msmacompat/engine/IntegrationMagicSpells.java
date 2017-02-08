package me.thecomputergeek2.msmacompat.engine;

import com.massivecraft.massivecore.Engine;
import com.massivecraft.massivecore.Integration;

public class IntegrationMagicSpells extends Integration
{
	
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static IntegrationMagicSpells i = new IntegrationMagicSpells();
	public static IntegrationMagicSpells get() { return i; }
	private IntegrationMagicSpells()
	{
		this.setPluginNames("MobArena", "MagicSpells");
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public Engine getEngine()
	{
		return EngineMagicSpells.get();
	}
	
}
