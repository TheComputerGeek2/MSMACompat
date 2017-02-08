package me.thecomputergeek2.msmacompat.entity;

import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MConf extends Entity<MConf>
{
	
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //
	
	protected static transient MConf i;
	public static MConf get() { return i; }
	
	public Set<String> disabledSpells = new HashSet<>();
	public Set<String> disabledOnBosses = new HashSet<>();
	public Set<String> disabledOnSwarms = new HashSet<>();
	
	// Aliases
	public List<String> aliasesMSMA = MUtil.list();
}
