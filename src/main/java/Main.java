import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void printSpielfeld(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] spielzug(String[][] board, int robox, int roboy, char robo1Symbol) {
        System.out.println("Bewege deinen Roboter (WASD) oder auf Position bleiben (Q)");
        boolean check_move = true;
        Scanner scan = new Scanner(System.in);

        while (check_move) {
            String move = scan.nextLine();
            switch (move) {
                case "W", "w" -> {
                    if (roboy > 0) {
                        board[roboy][robox] = "[ ]";
                        board[roboy - 1][robox] = "[" + robo1Symbol + "]";
                        roboy -= 1;
                        check_move = false;
                    } else {
                        System.out.println("Ungültiger Zug. Du kannst nicht weiter nach oben.");
                    }
                }
                case "A", "a" -> {
                    if (robox > 0) {
                        board[roboy][robox] = "[ ]";
                        board[roboy][robox - 1] = "[" + robo1Symbol + "]";
                        robox -= 1;
                        check_move = false;
                    } else {
                        System.out.println("Ungültiger Zug. Du kannst nicht weiter nach links.");
                    }
                }
                case "S", "s" -> {
                    if (roboy < 9) {
                        board[roboy][robox] = "[ ]";
                        board[roboy + 1][robox] = "[" + robo1Symbol + "]";
                        roboy += 1;
                        check_move = false;
                    } else {
                        System.out.println("Ungültiger Zug. Du kannst nicht weiter nach unten.");
                    }
                }
                case "D", "d" -> {
                    if (robox < 14) {
                        board[roboy][robox] = "[ ]";
                        board[roboy][robox + 1] = "[" + robo1Symbol + "]";
                        robox += 1;
                        check_move = false;
                    } else {
                        System.out.println("Ungültiger Zug. Du kannst nicht weiter nach rechts.");
                    }
                }
                case "Q", "q" -> check_move = false;
            }
        }
        return new int[]{robox, roboy};
    }

    public static void main(String[] args) throws InterruptedException {

// Intro mit ASCII-Art und Willkommensnachricht

        System.out.println("____/\\\\\\\\\\\\\\\\\\___________/\\\\\\\\\\_______/\\\\\\\\\\\\\\\\\\\\\\\\\\_________/\\\\\\\\\\_______/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\________________/\\\\\\______________/\\\\\\_____/\\\\\\\\\\\\\\\\\\_______/\\\\\\\\\\\\\\\\\\_________/\\\\\\\\\\\\\\\\\\\\\\___        ");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(" __/\\\\\\///////\\\\\\_______/\\\\\\///\\\\\\____\\/\\\\\\/////////\\\\\\_____/\\\\\\///\\\\\\____\\///////\\\\\\/////________________\\/\\\\\\_____________\\/\\\\\\___/\\\\\\\\\\\\\\\\\\\\\\\\\\___/\\\\\\///////\\\\\\_____/\\\\\\/////////\\\\\\_       ");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("  _\\/\\\\\\_____\\/\\\\\\_____/\\\\\\/__\\///\\\\\\__\\/\\\\\\_______\\/\\\\\\___/\\\\\\/__\\///\\\\\\________\\/\\\\\\_____________________\\/\\\\\\_____________\\/\\\\\\__/\\\\\\/////////\\\\\\_\\/\\\\\\_____\\/\\\\\\____\\//\\\\\\______\\///__      ");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("   _\\/\\\\\\\\\\\\\\\\\\\\\\/_____/\\\\\\______\\//\\\\\\_\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\___/\\\\\\______\\//\\\\\\_______\\/\\\\\\________/\\\\\\\\\\\\\\\\\\\\\\_\\//\\\\\\____/\\\\\\____/\\\\\\__\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\\\\\\\\\\\\\\\\\/______\\////\\\\\\_________     ");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("    _\\/\\\\\\//////\\\\\\____\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\/////////\\\\\\_\\/\\\\\\_______\\/\\\\\\_______\\/\\\\\\_______\\///////////___\\//\\\\\\__/\\\\\\\\\\__/\\\\\\___\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\_\\/\\\\\\//////\\\\\\_________\\////\\\\\\______    ");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("     _\\/\\\\\\____\\//\\\\\\___\\//\\\\\\______/\\\\\\__\\/\\\\\\_______\\/\\\\\\_\\//\\\\\\______/\\\\\\________\\/\\\\\\_______________________\\//\\\\\\/\\\\\\/\\\\\\/\\\\\\____\\/\\\\\\/////////\\\\\\_\\/\\\\\\____\\//\\\\\\___________\\////\\\\\\___   ");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("      _\\/\\\\\\_____\\//\\\\\\___\\///\\\\\\__/\\\\\\____\\/\\\\\\_______\\/\\\\\\__\\///\\\\\\__/\\\\\\__________\\/\\\\\\________________________\\//\\\\\\\\\\\\//\\\\\\\\\\_____\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\_____\\//\\\\\\___/\\\\\\______\\//\\\\\\__  ");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("       _\\/\\\\\\______\\//\\\\\\____\\///\\\\\\\\\\/_____\\/\\\\\\\\\\\\\\\\\\\\\\\\\\/_____\\///\\\\\\\\\\/___________\\/\\\\\\_________________________\\//\\\\\\__\\//\\\\\\______\\/\\\\\\_______\\/\\\\\\_\\/\\\\\\______\\//\\\\\\_\\///\\\\\\\\\\\\\\\\\\\\\\/___ ");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("        _\\///________\\///_______\\/////_______\\/////////////_________\\/////_____________\\///___________________________\\///____\\///_______\\///________\\///__\\///________\\///____\\///////////_____");

// Avatar-Name anlegen und check auf unerlaubte Zeichen

        String robo1Name = "A";
        String robo2Name = "B";
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        boolean unerlaubt = true;
        int bestaetigung = 1;

        while (bestaetigung == 1) {
            System.out.println("Bitte gib den Namen von Roboter 1 ein: ");
            robo1Name = scan1.nextLine();

            while (unerlaubt) {
                if (robo1Name.contains("^")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("°")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("!")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("²")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("§")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("³")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("$")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("%")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("&")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("/")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("{")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("(")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("[")) {
                    unerlaubt = true;
                } else if (robo1Name.contains(")")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("]")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("=")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("}")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("?")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("\\")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("´")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("`")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("+")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("*")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("#")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("'")) {
                    unerlaubt = true;
                } else if (robo1Name.contains(":")) {
                    unerlaubt = true;
                } else if (robo1Name.contains(";")) {
                    unerlaubt = true;
                } else if (robo1Name.contains(",")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("<")) {
                    unerlaubt = true;
                } else if (robo1Name.contains(">")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("|")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("@")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("€")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("µ")) {
                    unerlaubt = true;
                } else if (robo1Name.contains("\"")) {
                    unerlaubt = true;
                } else if (robo1Name.contains(" ")) {
                    unerlaubt = true;
                } else {
                    unerlaubt = false;
                }
                if (unerlaubt) {
                    System.out.println("Der Name " + robo1Name + " enthält ungültige Zeichen. Bitte erneut eingeben: ");
                    robo1Name = scan1.nextLine();
                }
            }
            System.out.println("Dein Name lautet: " + robo1Name + " Speichern (1) oder neu eingeben (2)?");
            boolean temp_bestaetigung2 = true;
            while (temp_bestaetigung2) {
                bestaetigung = scan2.nextInt();
                if (bestaetigung == 1) {
                    bestaetigung = 2;
                    temp_bestaetigung2 = false;
                    System.out.println("Der Name wurde gespeichert!");
                    unerlaubt = true;
                } else if (bestaetigung == 2) {
                    bestaetigung = 1;
                    temp_bestaetigung2 = false;
                    unerlaubt = true;
                } else {
                    System.out.println("Ungültig. Bitte bestätigen (1) oder neu eingeben (2).");
                    temp_bestaetigung2 = true;
                    unerlaubt = true;
                }
            }
        }

        char robo1Symbol;
        System.out.println("Bitte gib das Symbol ein, mit dem " + robo1Name + " dargestellt werden soll:");
        robo1Symbol = scan1.nextLine().charAt(0);
        System.out.println(robo1Name + ": " + robo1Symbol);

        unerlaubt = true;
        bestaetigung = 1;

        while (bestaetigung == 1) {
            System.out.println("Bitte gib den Namen von Roboter 2 ein: ");
            robo2Name = scan1.nextLine();

            while (unerlaubt) {
                if (robo2Name.contains("^")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("°")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("!")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("²")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("§")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("³")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("$")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("%")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("&")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("/")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("{")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("(")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("[")) {
                    unerlaubt = true;
                } else if (robo2Name.contains(")")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("]")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("=")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("}")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("?")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("\\")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("´")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("`")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("+")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("*")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("#")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("'")) {
                    unerlaubt = true;
                } else if (robo2Name.contains(":")) {
                    unerlaubt = true;
                } else if (robo2Name.contains(";")) {
                    unerlaubt = true;
                } else if (robo2Name.contains(",")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("<")) {
                    unerlaubt = true;
                } else if (robo2Name.contains(">")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("|")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("@")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("€")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("µ")) {
                    unerlaubt = true;
                } else if (robo2Name.contains("\"")) {
                    unerlaubt = true;
                } else if (robo2Name.contains(" ")) {
                    unerlaubt = true;
                } else {
                    unerlaubt = false;
                }
                if (unerlaubt) {
                    System.out.println("Der Name " + robo2Name + " enthält ungültige Zeichen. Bitte erneut eingeben: ");
                    robo2Name = scan1.nextLine();
                }
            }
            System.out.println("Dein Name lautet: " + robo2Name + " Speichern (1) oder neu eingeben (2)?");
            boolean temp_bestaetigung2 = true;
            while (temp_bestaetigung2) {
                bestaetigung = scan2.nextInt();
                if (bestaetigung == 1) {
                    bestaetigung = 2;
                    temp_bestaetigung2 = false;
                    System.out.println("Der Name wurde gespeichert!");
                    unerlaubt = true;
                } else if (bestaetigung == 2) {
                    bestaetigung = 1;
                    temp_bestaetigung2 = false;
                    unerlaubt = true;
                } else {
                    System.out.println("Ungültig. Bitte bestätigen (1) oder neu eingeben (2).");
                    temp_bestaetigung2 = true;
                    unerlaubt = true;
                }
            }
        }
        char robo2Symbol;
        System.out.println("Bitte gib das Symbol ein, mit dem " + robo2Name + " dargestellt werden soll:");
        robo2Symbol = scan1.nextLine().charAt(0);
        System.out.println(robo2Name + ": " + robo2Symbol);


// Spielfeld anlegen mit vorher abgefragter Roboterposition

        String[][] board = {{"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}};

        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);
        boolean position = true;
        int robo1X;
        int robo1Y;
        System.out.println("Auf welcher X-Position (1-15) möchtest du mit " + robo1Name + " starten?");
        robo1X = scan3.nextInt() - 1;
        System.out.println("Auf welcher Y-Position (1-10) möchtest du mit " + robo1Name + " starten?");
        robo1Y = scan4.nextInt() - 1;

        while (position) {
            if (robo1X < 0 || robo1X > 14 || robo1Y < 0 || robo1Y > 9) {
                position = true;
                System.out.println("Mindestens eine Koordinate befindet sich außerhalb des Spieldfeldes. Bitte erneut eingeben.");
                System.out.println("Auf welcher X-Position (1-15) möchtest du mit " + robo1Name + " starten?");
                robo1X = scan3.nextInt() - 1;
                System.out.println("Auf welcher Y-Position (1-10) möchtest du mit " + robo1Name + " starten?");
                robo1Y = scan4.nextInt() - 1;
            } else {
                position = false;
            }
        }
        board[robo1Y][robo1X] = "[" + robo1Symbol + "]";

        Random random = new Random();
        int robo2X = random.nextInt(14);
        int robo2Y = random.nextInt(9);

        if (robo2X == robo1X && robo2Y == robo1Y) {
            robo2X = random.nextInt(14);
            robo2Y = random.nextInt(9);
        }
        if (robo2X == robo1X && robo2Y == robo1Y) {
            robo2X = random.nextInt(14);
            robo2Y = random.nextInt(9);
        }
        if (robo2X == robo1X && robo2Y == robo1Y) {
            robo2X = random.nextInt(14);
            robo2Y = random.nextInt(9);
        }

        board[robo2Y][robo2X] = "[" + robo2Symbol + "]";

        printSpielfeld(board);

        System.out.println("\nRoboter 1 befindet sich in X=" + (robo1X + 1) + " Y=" + (robo1Y + 1));

        System.out.println("\nRoboter 2 befindet sich in X=" + (robo2X + 1) + " Y=" + (robo2Y + 1));
        System.out.println();

        int robo1Random = 0;
        int robo2Random = 0;

        for (int i = 0; i < 1000; i++) {
            if (robo1X == robo2X && robo1Y == robo2Y) {
                board[robo2Y][robo2X] = "[!]";
                System.out.println();
                printSpielfeld(board);
                TimeUnit.MILLISECONDS.sleep(2500);
                System.out.println("\n" + robo1Name + " und " + robo2Name + " treffen aufeinander. Es findet ein KAMPF statt!");
                while (robo1Random == robo2Random) {
                    TimeUnit.MILLISECONDS.sleep(2500);
                    robo1Random = (random.nextInt(6) + 1);
                    System.out.println("\n" + robo1Name + " würfelt eine " + robo1Random);
                    TimeUnit.MILLISECONDS.sleep(2500);
                    robo2Random = (random.nextInt(6) + 1);
                    System.out.println("\n" + robo2Name + " würfelt eine " + robo2Random);
                    System.out.println();
                    if (robo1Random == robo2Random) {
                        TimeUnit.MILLISECONDS.sleep(2500);
                        System.out.println("Gleiche Zahl. NOCHMAL!");
                    } else {
                        if (robo1Random > robo2Random) {
                            TimeUnit.MILLISECONDS.sleep(2700);
                            board[robo1Y][robo1X] = "[" + robo1Symbol + "]";
                            printSpielfeld(board);
                            System.out.println("\n" + robo1Name + " hat gewonnen!!!");
                        } else {
                            TimeUnit.MILLISECONDS.sleep(2700);
                            board[robo2Y][robo2X] = "[" + robo2Symbol + "]";
                            printSpielfeld(board);
                            System.out.println("\n" + robo2Name + " hat gewonnen!!!");
                        }
                    }
                }
                i = 1000;
            } else {
                int[] neuePosition = spielzug(board, robo1X, robo1Y, robo1Symbol);
                robo1X = neuePosition[0];
                robo1Y = neuePosition[1];
                printSpielfeld(board);
            }
        }
    }
}