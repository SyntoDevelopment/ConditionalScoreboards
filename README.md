
# Conditional Scoreboards

This allows you to use Assemble in a way which allows you to use different lines depending on certain conditions. 




## Acknowledgements

 - [Assemble](https://github.com/ThatKawaiiSam/Assemble)



## Authors

- [@SyntoDevelopment](https://www.github.com/syntodevelopment)


## 🎉 Basic Usage

```java
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
```


## Feedback

If you have any feedback, please reach out to me on discord @syntodev 😉

