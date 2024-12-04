package shadows.scenes;

import shadows.characters.Detective;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SceneManager {
    private final Detective detective;
    private final Scanner scanner;

    public SceneManager() {
        this.detective = new Detective("Jonas Quinn");
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Bem-vindo a Shadows of the Moon!");
        System.out.println("Uma mensagem de emergência veio da Estação Lunar Nova Aurora...");
        displayScene("scenes/laboratory.txt");
        mainMenu();
    }

    public void displayScene(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader("assets/" + filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar a cena: " + filePath);
            e.printStackTrace();
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\nEscolha sua próxima ação:");
            System.out.println("1. Explorar a Sala de Controle");
            System.out.println("2. Explorar os Alojamentos");
            System.out.println("3. Explorar as Minas Subterrâneas");
            System.out.println("4. Explorar o Domo de Observação");
            System.out.println("5. Ver Inventário");
            System.out.println("6. Sair do jogo");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> exploreScene("control_room", "Log Criptografado");
                case 2 -> exploreScene("lodgings", "Carta de Dívidas");
                case 3 -> exploreScene("mines", "Capacete com Aeternium");
                case 4 -> exploreScene("dome", "Fragmento de Vidro com Sangue");
                case 5 -> detective.showInventory();
                case 6 -> {
                    System.out.println("Encerrando o jogo. Até mais!");
                    System.exit(0);
                }
                default -> System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private void exploreScene(String sceneFile, String itemName) {
        displayScene("scenes/" + sceneFile + ".txt");
        detective.collectItem(itemName);
        detective.showInventory();
    }
}
