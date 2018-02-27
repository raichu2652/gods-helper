package Schedule;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Scheduler implements Runnable {
    /**
     * Enumerator Task is basically a set of commands which defines
     * a fine-grained command it could to tell the helper what to do next.
     * A task is one explicit action to perform in one shot, i.e.
     * clearing character/equipment inventory, buy some energy, but not
     * handling popups (we close the popup only and return the state),
     * having equipments on, for what? either specify the playing contents
     * and shoot the task directly, the equipments need to be double-confirmed
     * whenever re-login happens anyway (except for defending purpose).
     *
     * The tasks are rudimentary sorted. The one comes first in the list will
     * be executed earlier than the one listed afterwards. The order only matters
     * if two tasks are both in the queue.
     * */
    public enum Task {
        LOGIN,
        RESOLVE_CHARACTER_INVENTORY,
        RESOLVE_EQUIPMENT_INVENTORY,
        CLEAR_CHARACTER_INVENTORY,
        CLEAR_EQUIPMENT_INVENTORY,
        BUY_ENERGY,
        SUMMON_CHARACTER,
        SUMMON_EQUIPMENT,
        REINFORCE_CHARACTER,
        REINFORCE_EQUIPMENT,
        ELEVATE_CHARACTER,
        ELEVATE_EQUIPMENT,
        AMPLIFY_CHARACTER,
        AMPLIFY_EQUIPMENT,
        PLAY_FRIDGE,
        PLAY_ADVENTURE,
    }

    public Scheduler() {
        isCharacterInventoryFull = false;
        isEquipmentInventoryFull = false;
        isEnergyEmpty = false;
        isLoggedIn = true;

        queue = new PriorityQueue<Task>(new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                return t1.ordinal() - t2.ordinal();
            }
        });
        queue.add(Task.PLAY_ADVENTURE);
    }

    public void run() {

    }

    public static void schedule() {
        if (!isLoggedIn) {
            queue.add(Task.LOGIN);
        }
        if (isCharacterInventoryFull) {
            queue.add(Task.CLEAR_CHARACTER_INVENTORY);
        }
        if (isEquipmentInventoryFull) {
            queue.add(Task.CLEAR_EQUIPMENT_INVENTORY);
        }
        if (isEnergyEmpty) {
            queue.add(Task.BUY_ENERGY);
        }
    }

    /**
     * The implementation of this method will eventually replaced to
     * queue.poll().
     * peek() does not remove the object, while poll() does.
     * */
    public static Task getTask() {
        Task task = queue.poll();

        if (task == null) {
            return Task.PLAY_ADVENTURE;
        }

        return task;
    }

    public static void setIsInventoryFull(boolean bIsInventoryFull) {
        setIsCharacterInventoryFull(bIsInventoryFull);
        setIsEquipmentInventoryFull(bIsInventoryFull);
    }
    public static void setIsCharacterInventoryFull(boolean bIsCharacterInventoryFull) {
        isCharacterInventoryFull = bIsCharacterInventoryFull;
    }
    public static void setIsEquipmentInventoryFull(boolean bIsEquipmentInventoryFull) {
        isEquipmentInventoryFull = bIsEquipmentInventoryFull;
    }
    public static void setIsEnergyEmpty(boolean bIsEnergyEmpty) {
        isEnergyEmpty = bIsEnergyEmpty;
    }
    public static void setIsLoggedIn() {}

    private static boolean isCharacterInventoryFull;
    private static boolean isEquipmentInventoryFull;
    private static boolean isEnergyEmpty;
    private static boolean isLoggedIn;

    private static int numSandglass;
    private static int numFridgeTicket;

    private static PriorityQueue<Task> queue;
}
