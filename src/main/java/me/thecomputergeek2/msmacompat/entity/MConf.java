package me.thecomputergeek2.msmacompat.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EditorName("config")
public class MConf extends Entity<MConf>
{
	
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //
	
	protected static transient MConf i;
	public static MConf get() { return i; }
	
	public Set<String> disabledSpells = MUtil.set();
	public Set<String> disabledOnBosses = MUtil.set();
	public Set<String> disabledOnSwarms = MUtil.set();
	
	// Aliases
	public List<String> aliasesMSMA = MUtil.list("msma");
}
