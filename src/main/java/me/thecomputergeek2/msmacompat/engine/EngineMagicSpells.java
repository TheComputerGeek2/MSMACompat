package me.thecomputergeek2.msmacompat.engine;

import com.garbagemule.MobArena.MobArena;
import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.waves.Wave;
import com.garbagemule.MobArena.waves.WaveManager;
import com.garbagemule.MobArena.waves.enums.WaveType;
import com.massivecraft.massivecore.Engine;
import com.nisovin.magicspells.MagicSpells;
import com.nisovin.magicspells.Spell;
import com.nisovin.magicspells.events.SpellCastEvent;
import me.thecomputergeek2.msmacompat.entity.ArenaColl;
import me.thecomputergeek2.msmacompat.entity.MConf;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class EngineMagicSpells extends Engine
{
    
    // -------------------------------------------- //
    // INSTANCE & CONSTRUCT
    // -------------------------------------------- //
    
    private static EngineMagicSpells i = new EngineMagicSpells();
    public static EngineMagicSpells get() { return i; }
    
    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //
    
    protected MagicSpells magicSpells;
    protected MobArena mobArena;
    
    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //
    
    @Override
    public void setActiveInner(boolean active)
    {
        if (active)
        {
            this.magicSpells = MagicSpells.getInstance();
            this.mobArena = (MobArena) Bukkit.getPluginManager().getPlugin("MobArena");
        }
        else
        {
            this.magicSpells = null;
            this.mobArena = null;
        }
    }
    
    // -------------------------------------------- //
    // LISTENER
    // -------------------------------------------- //
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onSpellCast(SpellCastEvent event)
    {
        Arena arena = mobArena.getArenaMaster().getArenaWithPlayer(event.getCaster());
        if (arena == null || !arena.isRunning()) return;
    
        WaveManager manager = arena.getWaveManager();
        Wave current = manager.getCurrent();
        WaveType type = (current != null) ? current.getType() : null;
        
        if (shouldCancelCast(event, type, arena.arenaName())) event.setCancelled(true);
    }
    
    public boolean shouldCancelCast(SpellCastEvent event, WaveType type, String arenaName)
    {
        Spell spell = event.getSpell();
        String internalName = spell.getInternalName();
        
        // Check the global rules
        if (MConf.get().disabledSpells.contains(internalName)) return true;
        if (type == WaveType.BOSS && MConf.get().disabledOnBosses.contains(internalName)) return true;
        if (type == WaveType.SWARM && MConf.get().disabledOnSwarms.contains(internalName)) return true;
        
        // Now let's see if there are any arena specific rules
        me.thecomputergeek2.msmacompat.entity.Arena arenaInfo = ArenaColl.get().getByName(arenaName);
        if (arenaInfo == null) return false;
        
        if (arenaInfo.getDisabledSpells().contains(internalName)) return true;
        if (type == WaveType.BOSS && arenaInfo.getDisabledOnBosses().contains(internalName)) return true;
        if (type == WaveType.SWARM && arenaInfo.getDisabledOnSwarms().contains(internalName)) return true;
        
        return false;
    }
    
}
