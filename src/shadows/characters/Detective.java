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

    // Método polimórfico 1
    public void performAction() {
        System.out.println(name + " está investigando o caso...");
    }

    // Método polimórfico 2 (sobrecarga)
    public void performAction(String location) {
        System.out.println(name + " está investigando o caso no local: " + location);
    }

    public void introduce() {
        System.out.println("Detetive " + name + " à disposição para resolver o caso.");
    }

    public void collectItem(String item) {
        inventory.add(item);
        System.out.println(name + " coletou: " + item);
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println(name + " tem um inventário vazio.");
        } else {
            System.out.println(name + " possui os seguintes itens no inventário:");
            for (String item : inventory) {
                System.out.println("- " + item);
            }
        }
    }
}
