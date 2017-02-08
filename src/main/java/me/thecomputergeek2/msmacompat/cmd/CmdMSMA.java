package me.thecomputergeek2.msmacompat.cmd;

import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.MassiveCommandVersion;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import me.thecomputergeek2.msmacompat.MSMACompat;
import me.thecomputergeek2.msmacompat.Perm;
import me.thecomputergeek2.msmacompat.entity.MConf;

import java.util.List;

public class CmdMSMA extends MassiveCommand
{
	// Instance
	private static CmdMSMA i = new CmdMSMA();
	public static CmdMSMA get() { return i; }
	
	// Children
	public MassiveCommandVersion cmdVersion = new MassiveCommandVersion(MSMACompat.get()).addRequirements(RequirementHasPerm.get(Perm.VERSION));
	public CmdMSMAConfig cmdConfig = new CmdMSMAConfig();
	
	public CmdMSMA()
	{
		// Children
		this.addChild(this.cmdConfig);
		this.addChild(this.cmdVersion);
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.BASECOMMAND));
	}
	
	@Override
	public List<String> getAliases()
	{
		return MConf.get().aliasesMSMA;
	}
}
