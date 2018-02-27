package Menu;

import Schedule.Scheduler;

import static Menu.AdventureMenu.AdventureMenuEntry.*;

public class AdventureMenu extends Menu {
    public enum AdventureMenuEntry implements MenuEntry {
        MAIN,
        CHARACTER,
        PIGEAR
    }

    public enum AdventureMode { NORM, HELL }

    public AdventureMenu() {
        // Load required images
    }

    @Override
    public boolean clearPopup() {
        if (existsExact("")) {
            Scheduler.setIsInventoryFull(true);
            clickExact("");

            return false;
        } else if (existsExact("")) {
            Scheduler.setIsEnergyEmpty(true);
            clickExact("");

            return false;
        } else {
            return super.clearPopup();
        }
    }

    @Override
    public void enter(MenuEntry menuEntry) {
        if (menuEntry == MAIN) {

        } else if (menuEntry == CHARACTER) {

        } else if (menuEntry == PIGEAR) {

        } else {

        }
    }

    public void run(final AdventureMode mode, final int chapter, final int stage) {
        assert chapter >= 1 && chapter <= 11 : "Invalid chapter specified";
        assert stage >= 1 && stage <= 10 : "Invalid stage specified.";
    }

    private void selectMode(final AdventureMode mode) {

    }

    private void selectChapter(final int chapter) {

    }

    private void selectStage(final int stage) {

    }
}
