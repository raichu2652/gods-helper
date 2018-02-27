package Menu;

import Schedule.Scheduler;

import static Menu.MainMenu.MainMenuEntry.*;

public class MainMenu extends Menu {
    public enum MainMenuEntry implements MenuEntry {
        CHARACTER,
        EQUIPMENT,
        SHOP,
        ADVENTURE
    }

    public MainMenu() {
        // Load required images
    }

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

    public void enter(MenuEntry menuEntry) {
        if (menuEntry == ADVENTURE) {

        } else if (menuEntry == CHARACTER) {

        } else if (menuEntry == EQUIPMENT) {

        } else if (menuEntry == SHOP) {

        } else {

        }
    }
}
