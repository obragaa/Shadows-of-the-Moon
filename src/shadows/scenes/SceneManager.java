package shadows.scenes;

import shadows.characters.Detective;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SceneManager {
    private final Detective detective;
    private final Scanner scanner;
    private final Map<String, String> clues; // Pistas coletadas
    private final Map<String, Boolean> interrogated; // Quem foi interrogado
    private final List<String> suspects;
    private int explorationLimit = 3; // Limite de explorações
    private int interrogationLimit = 4; // Limite de interrogatórios
    private final Set<String> exploredSectors = new HashSet<>(); // Setores já explorados


    public SceneManager() {
        this.detective = new Detective("Jonas Quinn");
        this.scanner = new Scanner(System.in);
        this.clues = new HashMap<>();
        this.suspects = Arrays.asList("Dr. Elena Voss", "Marcus Kane", "Ivy Prescott", "Dr. Julian Hayes", "Sophia Vega", "Liam Ortega");
        this.interrogated = new HashMap<>();
        for (String suspect : suspects) {
            interrogated.put(suspect, false);
        }
    }

    public void startGame() {
        printIntro();
        displaySuspectList();
        mainMenu();
    }

    private void printLine() {
        System.out.println(" ");
    }

    private void printIntro() {
        System.out.println("============================================================");
        System.out.println("               *** SHADOWS OF THE MOON ***");
        System.out.println("============================================================");
        System.out.println("\n>>> Ano 2147. No lado oculto da Lua, onde a escuridão eterna reina,");
        System.out.println(">>> a Estação Lunar Nova Aurora se ergue como um farol de inovação.");
        System.out.println(">>> Contudo, esse farol esconde segredos tão sombrios quanto o vácuo que o cerca.");
        printLine();
        System.out.println("\n>>> Uma mensagem de emergência atravessa as frequências interplanetárias.");
        System.out.println(">>> É Sophia Vega, coordenadora de operações:");
        System.out.println("\n\"Aqui é Sophia Vega, da Estação Lunar Nova Aurora. Nosso comandante,");
        System.out.println("Dr. Alastair Creed, foi encontrado morto no laboratório. Solicitamos ajuda imediata.\"");
        printLine();
        System.out.println("\n>>> Você é Jonas Quinn, um detetive renomado, enviado para resolver o caso");
        System.out.println(">>> antes que a estação se torne o palco de um desastre ainda maior.");
        System.out.println(">>> Mas algo na voz de Sophia não soa certo. O que ela está escondendo?");
        printLine();
        System.out.println("\n>>> Ao chegar, a estação parece uma prisão: corredores vazios, sombras longas,");
        System.out.println(">>> e seis rostos que não inspiram confiança. Cada um deles tem algo a perder.");
        System.out.println(">>> Cada um deles poderia ser o culpado.");
        printLine();
        System.out.println("\n>>> Seu trabalho:");
        System.out.println("1. Explorar a estação e reunir as pistas espalhadas pelos setores.");
        System.out.println("2. Interrogar os suspeitos e pressioná-los para encontrar as falhas em seus álibis.");
        System.out.println("3. Decifrar quem está mentindo e acusar o culpado.");
        printLine();
        System.out.println("\n>>> Mas cuidado... Cada ação conta. O tempo é curto, e o verdadeiro assassino pode estar observando seus passos.");
        printLine();
        System.out.println("\nVocê é Jonas Quinn. O destino da estação depende de você.");
        printLine();
    }

    private void showClues() {
        printLine();
        System.out.println("PISTAS COLETADAS:");
        if (clues.isEmpty()) {
            System.out.println("Nenhuma pista coletada ainda.");
        } else {
            for (Map.Entry<String, String> entry : clues.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }
        printLine();
    }

    private void accuseSuspect() {
        System.out.println("\nEscolha o suspeito para acusar:");
        for (int i = 0; i < suspects.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + suspects.get(i));
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > suspects.size()) {
            System.out.println("Opção inválida. Escolha um suspeito válido.");
            return;
        }

        String suspect = suspects.get(choice - 1);

        if ("Sophia Vega".equals(suspect)) {
            System.out.println("\nParabéns! Você descobriu o culpado: Sophia Vega.");
            System.out.println("Ela confessou o crime e foi presa.");
            System.out.println("\nFim do jogo. Obrigado por jogar!");
        } else {
            triggerWrongAccusationEnding(suspect);
        }

        System.exit(0);
    }

    private void triggerWrongAccusationEnding(String suspect) {
        switch (suspect) {
            case "Dr. Elena Voss" -> {
                System.out.println("\nVocê acusou Dr. Elena Voss!");
                System.out.println("Enquanto você a pressiona, o sistema de oxigênio da estação falha misteriosamente.");
                System.out.println("A estação inteira é comprometida. Sophia usou o caos para escapar.");
                System.out.println("Fim trágico: A estação é destruída, e o culpado escapa.");
            }
            case "Marcus Kane" -> {
                System.out.println("\nVocê acusou Marcus Kane!");
                System.out.println("Durante a acusação, Marcus perde a paciência, mas uma explosão ocorre nas minas.");
                System.out.println("Sophia armou tudo e foge enquanto a estação é destruída.");
                System.out.println("Fim trágico: Você se perde nos destroços.");
            }
            case "Ivy Prescott" -> {
                System.out.println("\nVocê acusou Ivy Prescott!");
                System.out.println("Ivy grita sua inocência, mas Sophia ativa um vírus no sistema da estação.");
                System.out.println("O reator central superaquecido destrói tudo.");
                System.out.println("Fim trágico: Você não sobrevive.");
            }
            case "Dr. Julian Hayes" -> {
                System.out.println("\nVocê acusou Dr. Julian Hayes!");
                System.out.println("Julian tenta confessar seus erros financeiros, mas Sophia rouba a cápsula de fuga.");
                System.out.println("Fim trágico: Você é deixado preso na estação.");
            }
            case "Liam Ortega" -> {
                System.out.println("\nVocê acusou Liam Ortega!");
                System.out.println("Liam tenta se defender, mas Sophia ativa uma mensagem para mercenários externos.");
                System.out.println("Mercenários invadem a estação e eliminam todos.");
                System.out.println("Fim trágico: Ninguém sobrevive.");
            }
        }

        System.out.println("\nO verdadeiro culpado era Sophia Vega.");
        System.out.println("Fim do jogo. Obrigado por jogar!");
    }

    private void displayScene(String filePath) {
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

    private void displaySuspectList() {
        printLine();
        System.out.println("LISTA DE SUSPEITOS:");
        for (String suspect : suspects) {
            System.out.println("- " + suspect + ": " + getBriefDescription(suspect));
        }
        printLine();
    }

    private String getBriefDescription(String suspect) {
        return switch (suspect) {
            case "Dr. Elena Voss" -> "Cientista arrogante com conflitos sobre orçamento.";
            case "Marcus Kane" -> "Engenheiro explosivo, acusado por atrasos.";
            case "Ivy Prescott" -> "Mineradora determinada, desconfia de todos.";
            case "Dr. Julian Hayes" -> "Médico nervoso, cheio de dívidas.";
            case "Sophia Vega" -> "Coordenadora calculista, sempre no controle.";
            case "Liam Ortega" -> "Segurança reservado, envolvido em contrabando.";
            default -> "Descrição não encontrada.";
        };
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\nO que você deseja fazer?");
            System.out.println("[1] Explorar setores (" + explorationLimit + " ações restantes)");
            System.out.println("[2] Interrogar suspeitos (" + interrogationLimit + " ações restantes)");
            System.out.println("[3] Ver pistas coletadas");
            System.out.println("[4] Acusar um suspeito");
            System.out.println("[5] Sair do jogo");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    if (explorationLimit > 0) {
                        exploreSector();
                        explorationLimit--;
                    } else {
                        System.out.println("Você já explorou o número máximo de setores.");
                    }
                }
                case 2 -> {
                    if (interrogationLimit > 0) {
                        interrogateSuspect();
                        interrogationLimit--;
                    } else {
                        System.out.println("Você já interrogou o número máximo de suspeitos.");
                    }
                }
                case 3 -> showClues();
                case 4 -> accuseSuspect();
                case 5 -> {
                    System.out.println("Encerrando o jogo. Até logo!");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exploreSector() {
        System.out.println("\nEscolha o setor para explorar:");
        System.out.println("[1] Laboratório de Pesquisa");
        System.out.println("[2] Sala de Controle");
        System.out.println("[3] Alojamentos");
        System.out.println("[4] Minas Subterrâneas");
        System.out.println("[5] Domo de Observação");

        int choice = scanner.nextInt();
        scanner.nextLine();

        String sector = switch (choice) {
            case 1 -> "Laboratório de Pesquisa";
            case 2 -> "Sala de Controle";
            case 3 -> "Alojamentos";
            case 4 -> "Minas Subterrâneas";
            case 5 -> "Domo de Observação";
            default -> null;
        };

        if (sector == null) {
            System.out.println("Setor inválido.");
            return;
        }

        if (exploredSectors.contains(sector)) {
            System.out.println("Você já explorou o setor " + sector + ". Escolha outro lugar.");
            return;
        }

        exploredSectors.add(sector);
        String clue = switch (choice) {
            case 1 -> "Fragmento de vidro com sangue";
            case 2 -> "Log Criptografado";
            case 3 -> "Carta de Dívidas";
            case 4 -> "Capacete com Aeternium";
            case 5 -> "Objeto cortante com digitais";
            default -> null;
        };

        if (clue != null) {
            revealClue(clue, "scenes/" + sector.toLowerCase().replace(" ", "_") + ".txt");
        }
    }

    private void revealClue(String clue, String sceneFile) {
        displayScene(sceneFile);
        clues.put(clue, "Coletado");
        System.out.println("Você coletou uma pista: " + clue);
        provideClueDetails(clue);
    }

    private void provideClueDetails(String clue) {
        switch (clue) {
            case "Fragmento de vidro com sangue" -> System.out.println(
                "Este fragmento é de um copo quebrado, encontrado no laboratório."
            );
            case "Log Criptografado" -> System.out.println(
                "Um log criptografado menciona uma entrega secreta na noite do crime."
            );
            case "Carta de Dívidas" -> System.out.println(
                "Uma carta de Creed pressionando Julian Hayes sobre dívidas financeiras."
            );
            case "Capacete com Aeternium" -> System.out.println(
                "Um capacete sujo de Aeternium, pertencente a Ivy Prescott."
            );
            case "Objeto cortante com digitais" -> System.out.println(
                "O objeto cortante tem as digitais de Sophia Vega."
            );
            default -> System.out.println("Sem detalhes adicionais.");
        }
    }

    private void interrogateSuspect() {
        System.out.println("\nEscolha o suspeito para interrogar:");
        for (int i = 0; i < suspects.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + suspects.get(i));
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > suspects.size()) {
            System.out.println("Suspeito inválido.");
            return;
        }

        String suspect = suspects.get(choice - 1);
        if (interrogated.get(suspect)) {
            System.out.println("Você já interrogou " + suspect + ". Escolha outro suspeito.");
            return;
        }

        interrogated.put(suspect, true);
        System.out.println("\nInterrogando: " + suspect);

        switch (suspect) {
            case "Dr. Elena Voss" -> elenaDialogues();
            case "Marcus Kane" -> marcusDialogues();
            case "Ivy Prescott" -> ivyDialogues();
            case "Dr. Julian Hayes" -> julianDialogues();
            case "Sophia Vega" -> sophiaDialogues();
            case "Liam Ortega" -> liamDialogues();
        }
    }

    private void elenaDialogues() {
        System.out.println("Elena: Creed me humilhava publicamente, mas não faria nada contra ele.");
        System.out.println("Elena: Na noite do crime, estava no laboratório.");
        System.out.println("Elena: Tinha meus próprios problemas com orçamento. Pergunte a Sophia!");
    }

    private void marcusDialogues() {
        System.out.println("Marcus: Creed sempre me culpava por falhas técnicas.");
        System.out.println("Marcus: Estava na manutenção naquela noite.");
        System.out.println("Marcus: Você deveria conferir os logs da sala de controle.");
    }

    private void ivyDialogues() {
        System.out.println("Ivy: Creed me ameaçava o tempo todo.");
        System.out.println("Ivy: Estava descansando, mas as minas estão sempre suspeitas.");
        System.out.println("Ivy: Acho que Sophia não é confiável.");
    }

    private void julianDialogues() {
        System.out.println("Julian: Creed sabia das minhas dívidas. Ele usava isso pra me manipular.");
        System.out.println("Julian: Na noite do crime, eu estava revisando equipamentos médicos na enfermaria.");
        System.out.println("Julian: Creed parecia assustado ultimamente. Como se alguém estivesse atrás dele.");
    }

    private void sophiaDialogues() {
        System.out.println("Sophia: Creed era paranoico, sempre achava que alguém queria roubar o projeto dele.");
        System.out.println("Sophia: Eu estava na sala de controle na noite do crime, revisando relatórios.");
        System.out.println("Sophia: Se quer um conselho, olhe para Ivy. Ela discutiu com Creed na semana passada.");
    }

    private void liamDialogues() {
        System.out.println("Liam: Creed era imprudente. Ele nunca respeitava os protocolos de segurança.");
        System.out.println("Liam: Eu estava patrulhando as minas na noite do crime. Pode verificar os registros.");
        System.out.println("Liam: Creed sabia demais sobre as operações ilegais aqui. Isso o tornou um alvo.");
    }
}
