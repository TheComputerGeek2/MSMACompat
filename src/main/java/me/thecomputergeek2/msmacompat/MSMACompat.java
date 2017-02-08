package me.thecomputergeek2.msmacompat;

import com.massivecraft.massivecore.MassivePlugin;
import me.thecomputergeek2.msmacompat.cmd.CmdMSMA;
import me.thecomputergeek2.msmacompat.engine.IntegrationMagicSpells;
import me.thecomputergeek2.msmacompat.entity.MConfColl;

public class MSMACompat extends MassivePlugin
{
	
	public static final String INSTANCE = "instance";
	
	private static MSMACompat i;
	public static MSMACompat get() { return i; }
	
	public MSMACompat()
	{
		MSMACompat.i = this;
	}
	
	@Override
	public void onEnableInner()
	{
		
		this.activate(
			// Collections
			MConfColl.class,
			
			// "Integration"
			IntegrationMagicSpells.class,
			
			// Command
			CmdMSMA.class
		);
		
	}
	
	@Override
	public void onDisable()
	{
		super.onDisable();
	}
	
}
