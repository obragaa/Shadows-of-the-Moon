package shadows.characters;

public class Character {
    protected String name;

    public Character(String name) {
        this.name = name;
    }

    public void performAction() {
        System.out.println(name + " está realizando uma ação...");
    }

    public void introduce() {
        System.out.println("Meu nome é " + name);
    }
}
