package shadows.items;

public class SpecialItem extends Item {
    private final String specialEffect;

    public SpecialItem(String name, String description, String specialEffect) {
        super(name, description);
        this.specialEffect = specialEffect;
    }

    // Sobrescrita 1: Modifica a inspeção do item
    @Override
    public void inspect() {
        super.inspect();
        System.out.println("Efeito Especial: " + specialEffect);
    }

    // Sobrescrita 2: Modifica a descrição do item
    @Override
    public String getDescription() {
        return super.getDescription() + " [Efeito Especial: " + specialEffect + "]";
    }

    // Novo método para usar o item especial
    public void useItem() {
        System.out.println("Usando o item especial: " + getName() + " - " + specialEffect);
    }
}
