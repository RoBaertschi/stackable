package robaertschi.stackable.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "stackable")
public class ModConfig implements ConfigData {

    // Stacksize for every Item.
    public int stackSize = 64;
    public boolean onlyUnstackables = false;
    public boolean onlyStackables = false;
    public boolean forceStackSize = false;
    public boolean turnWarningsOff = false;
    // public boolean onlyTools = false;

}
