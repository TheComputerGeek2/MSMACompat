package me.thecomputergeek2.msmacompat.cmd;

import com.massivecraft.massivecore.command.editor.CommandEditSingleton;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import me.thecomputergeek2.msmacompat.Perm;
import me.thecomputergeek2.msmacompat.entity.MConf;

public class CmdMSMAConfig extends CommandEditSingleton<MConf>
{
	
	
	public CmdMSMAConfig()
	{
		super(MConf.get());
		
		// Requirements
		this.addRequirements(RequirementHasPerm.get(Perm.CONFIG));
	}
	
}
