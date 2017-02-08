package me.thecomputergeek2.msmacompat.engine;

import com.massivecraft.massivecore.Engine;
import com.massivecraft.massivecore.Integration;

public class IntegrationMobArena extends Integration
{
	
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static IntegrationMobArena i = new IntegrationMobArena();
	public static IntegrationMobArena get() { return i; }
	private IntegrationMobArena()
	{
		this.setPluginNames("MobArena");
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public Engine getEngine()
	{
		return EngineMobArena.get();
	}
	
	
}
