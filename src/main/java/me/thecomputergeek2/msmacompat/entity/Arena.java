package me.thecomputergeek2.msmacompat.entity;

import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;

import java.util.Set;

public class Arena extends Entity<Arena>
{
	
	public Arena()
	{
		
	}
	
	private String name;
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; this.changed(); }
	
	private Set<String> disabledSpells = MUtil.set();
	public Set<String> getDisabledSpells() { return this.disabledSpells; }
	public void setDisabledSpells(Set<String> disabled) { this.disabledSpells = disabled; this.changed(); }
	
	private Set<String> disabledOnBosses = MUtil.set();
	public Set<String> getDisabledOnBosses() { return this.disabledOnBosses; }
	public void setDisabledOnBosses(Set<String> disabled) { this.disabledOnBosses = disabled; this.changed(); }
	
	private Set<String> disabledOnSwarms = MUtil.set();
	public Set<String> getDisabledOnSwarms() { return this.disabledOnSwarms; }
	public void setDisabledOnSwarms(Set<String> disabled) { this.disabledOnSwarms = disabled; this.changed(); }
	
}
