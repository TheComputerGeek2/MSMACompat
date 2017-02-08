package me.thecomputergeek2.msmacompat.entity;

import com.massivecraft.massivecore.store.Coll;

import java.util.Collection;

public class ArenaColl extends Coll<Arena>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static ArenaColl i = new ArenaColl();
	public static ArenaColl get() { return i; }

	// -------------------------------------------- //
	// STACK TRACEABILITY
	// -------------------------------------------- //
	
	@Override
	public void onTick()
	{
		super.onTick();
	}
	
	// -------------------------------------------- //
	// OVERRIDE: COLL
	// -------------------------------------------- //
	
	@Override
	public void setActive(boolean active)
	{
		super.setActive(active);
	}
	
	@Override
	public Arena get(Object oid)
	{
		return super.get(oid);
	}
	
	@Override
	public Arena getByName(String name)
	{
		for (Arena arena : this.getAll())
		{
			if (arena.getName().equals(name))
			{
				return arena;
			}
		}
		return null;
	}
	
	public void ensureArenaDataFiles(Collection<String> names)
	{
		for (String name: names)
		{
			if (this.getByName(name) != null) continue;
			
			Arena a = new Arena();
			a.setName(name);
			this.attach(a);
		}
	}


}
