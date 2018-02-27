package Menu;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public abstract class Menu {
    public void back() {
        this.clickExact("back.png");
    }

    /**
     * @return true if there is no popup on the screen
     * */
    public boolean clearPopup() {
        if (existsExact("")) {
            return false;
        } else {
            return true;
        }
    }

    public abstract void enter(MenuEntry menuEntry);

    boolean existsExact(String imagePath) {
        try {
            Match match = screen.find(imagePath);
            return (match.exists(new Pattern(imagePath).exact()) != null);
        } catch (FindFailed findFailedException) {
            findFailedException.printStackTrace();
        }
        return false;
    }

    void clickExact(String imagePath) {
        try {
            Match match = screen.find(imagePath);
            Match exactMatch = match.exists(new Pattern(imagePath).exact());
            if (exactMatch != null) {
                screen.click(exactMatch);
            } else {
                throw new FindFailed("Exact image not found");
            }
        } catch (FindFailed findFailedException) {
            findFailedException.printStackTrace();
        }
    }

    private Screen screen;
}
