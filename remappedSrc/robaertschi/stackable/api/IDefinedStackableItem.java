package robaertschi.stackable.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This Interface defines any Item that you want to change the default stack size. Use this only if your Mod breaks when you change the Stack size.
 * You can also just send an Warning to the Player.
 * ATTENTION: The player can force your Mod.
 */
public interface IDefinedStackableItem {
    /**
     * Return the allowed max stack size. If the user uses a lower Stack Size then this. It will use the lower one. If it is higher it will use the max one.
     * @return The maximal allowed Stick Size of a Item.
     */
    public int getMaxStackSize();

    /**
     * The Warning that will be displayed if the Mod does not support this Mod.
     * @return Returns a warning to the User or null if you dont want to warn them.
     */
    default public String getWarning() {
        return null;
    }

    /**
     * The warning that will be displayed if the stack size got forced by the user. Use that if you Mod will break with a different Stack size then normal.
     * This function will only be run if allowForcedStackSize returns false.
     * @return Returns a warning to the User or null if your mod doesn't break with this mod.
     */
    default public String getForceWarning() {
        return null;
    }

    default public boolean allowForcedStackSize() {
        return true;
    }



}
