package shadows.characters;

import java.util.ArrayList;
import java.util.List;

public class Detective {
    private final String name;
    private final List<String> inventory;

    public Detective(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void collectItem(String item) {
        inventory.add(item);
        System.out.println("Você coletou: " + item);
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (String item : inventory) {
                System.out.println("- " + item);
            }
        }
    }
}
