package me.thecomputergeek2.msmacompat.engine;

import com.garbagemule.MobArena.MobArena;
import com.garbagemule.MobArena.framework.Arena;
import com.massivecraft.massivecore.Engine;
import com.massivecraft.massivecore.util.MUtil;
import me.thecomputergeek2.msmacompat.entity.ArenaColl;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.Set;

public class EngineMobArena extends Engine
{
    
    // -------------------------------------------- //
    // INSTANCE & CONSTRUCT
    // -------------------------------------------- //
    
    private static EngineMobArena i = new EngineMobArena();
    public static EngineMobArena get() { return i; }
    
    public EngineMobArena()
    {
        this.setPeriod(40L); // 2 seconds
    }
    
    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //
    
    protected MobArena mobArena;
    
    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //
    
    @Override
    public void setActiveInner(boolean active)
    {
        if (active)
        {
            this.mobArena = (MobArena) Bukkit.getPluginManager().getPlugin("MobArena");
        }
        else
        {
            this.mobArena = null;
        }
    }
    
    @Override
    public void run()
    {
        List<Arena> arenas = mobArena.getArenaMaster().getArenas();
        Set<String> names = MUtil.set();
        for (Arena a: arenas) {
            names.add(a.arenaName());
        }
        
        ArenaColl.get().ensureArenaDataFiles(names);
    }
    
}
