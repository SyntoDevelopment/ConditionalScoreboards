package dev.synto.scoreboard.example;

import dev.synto.scoreboard.display.DisplayProvider;
import dev.synto.scoreboard.display.DisplayService;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleAdapter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class ScoreboardExample extends JavaPlugin {

    private DisplayService displayService;

    @Override
    public void onEnable() {
        displayService = new DisplayService();
        displayService.registerProvider(new DisplayProvider() {
            @Override
            public boolean isActive(Player player) {
                return player.isFlying();
            }

            @Override
            public List<String> getLines(Player player) {
                return Arrays.asList("You are flying!");
            }

            @Override
            public int getWeight() {
                return 0;
            }
        });

        Assemble assemble = new Assemble(this, new AssembleAdapter() {
            @Override
            public String getTitle(Player player) {
                return "Title";
            }

            @Override
            public List<String> getLines(Player player) {
                return displayService.getDisplayList(player) != null ? displayService.getDisplayList(player) : Arrays.asList("Default scoreboard");
            }
        });
    }
}
