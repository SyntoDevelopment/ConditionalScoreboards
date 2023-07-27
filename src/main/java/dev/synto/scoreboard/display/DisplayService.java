package dev.synto.scoreboard.display;


import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;

public class DisplayService {
    private final List<DisplayProvider> displayServiceList;

    public DisplayService() {
        this.displayServiceList = new LinkedList<>();
    }

    public void registerProvider(DisplayProvider displayProvider) {
        displayServiceList.add(displayProvider);
    }

    public List<String> getDisplayList(Player player) {
        DisplayProvider activeProvider = null;
        int highestWeight = Integer.MIN_VALUE;

        for (DisplayProvider provider : displayServiceList) {
            if (provider.isActive(player) && provider.getWeight() > highestWeight) {
                activeProvider = provider;
                highestWeight = provider.getWeight();
            }
        }

        if (activeProvider != null) {
            return activeProvider.getLines(player);
        }

        return null;
    }
}
