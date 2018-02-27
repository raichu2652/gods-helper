import Menu.AdventureMenu;
import Menu.MainMenu;
import Menu.Menu;
import Schedule.Scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static Menu.AdventureMenu.AdventureMode.HELL;
import static Menu.MainMenu.MainMenuEntry.ADVENTURE;

public class GodsHelper implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new GodsHelper());
        thread.start();

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new GodsHelper(), 0, 1000, TimeUnit.MILLISECONDS);
    }

    public void run() {
        checkStatus();
        Scheduler.schedule();
        // check the current state, includes popup handling
        // menu = MainMenu, AdventureMenu, NOT AVAILABLE? (login on another device, ...), ...

        // dequeue the highest priority task to run
        // execute the task
        Scheduler.Task task = Scheduler.getTask();
        switch (task) {
            case CLEAR_CHARACTER_INVENTORY:
                clearCharacterInventory();
                break;
            case CLEAR_EQUIPMENT_INVENTORY:
                clearEquipmentInventory();
                break;
            case BUY_ENERGY:
                buyEnergy(20);
            case PLAY_ADVENTURE:
            default:
                goAdventure();
        }
    }

    private void checkStatus() {
        if (menu != null) {
            while (!menu.clearPopup()) {

            }
        }

        // detect if menu is still reliable
    }

    private void clearCharacterInventory() {

    }

    private void clearEquipmentInventory() {

    }

    private void buyEnergy(int numEnergy) {

    }

    private void goAdventure() {
        // assume chars and equips are all set
        menu = new MainMenu();
        menu.enter(ADVENTURE);

        menu = new AdventureMenu();
        AdventureMenu adventureMenu = (AdventureMenu) menu;
        adventureMenu.run(HELL, 8, 4);
    }

    private Menu menu;
}
