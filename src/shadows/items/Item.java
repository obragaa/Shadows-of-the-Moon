package shadows.items;

public class Item {
    private final String name;
    private final String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void inspect() {
        System.out.println("Item: " + name);
        System.out.println("Descrição: " + description);
    }
}
