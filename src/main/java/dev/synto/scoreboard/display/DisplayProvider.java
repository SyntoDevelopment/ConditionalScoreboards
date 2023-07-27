package dev.synto.scoreboard.display;

import org.bukkit.entity.Player;

import java.util.List;

public interface DisplayProvider {
    boolean isActive(Player player);

    List<String> getLines(Player player);

    int getWeight();
}
