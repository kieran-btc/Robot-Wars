import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {

    public static void printSpielfeld(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] spielzug(String[][] board, int robox, int roboy) {
        System.out.println("Bewege deinen Roboter (WASD) oder auf Position bleiben (Q)");
        boolean check_move = true;
        Scanner scan = new Scanner(System.in);

        while (check_move) {
            String move = scan.nextLine();
            switch (move) {
                case "W", "w" -> {
                    if (roboy > 0) {
                        board[roboy][robox] = "[ ]";
                        board[roboy - 1][robox] = "[Ö]";
                        roboy -= 1;
                        check_move = false;
                    } else {
                        System.out.println("Ungültiger Zug. Du kannst nicht weiter nach oben.");
                    }
                }
                case "A", "a" -> {
                    if (robox > 0) {
                        board[roboy][robox] = "[ ]";
                        board[roboy][robox - 1] = "[Ö]";
                        robox -= 1;
                        check_move = false;
                    } else {
                        System.out.println("Ungültiger Zug. Du kannst nicht weiter nach links.");
                    }
                }
                case "S", "s" -> {
                    if (roboy < 9) {
                        board[roboy][robox] = "[ ]";
                        board[roboy + 1][robox] = "[Ö]";
                        roboy += 1;
                        check_move = false;
                    } else {
                        System.out.println("Ungültiger Zug. Du kannst nicht weiter nach unten.");
                    }
                }
                case "D", "d" -> {
                    if (robox < 14) {
                        board[roboy][robox] = "[ ]";
                        board[roboy][robox + 1] = "[Ö]";
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

        String avatar;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        boolean unerlaubt = true;
        int bestaetigung = 1;

        while (bestaetigung == 1) {
            System.out.println("Bitte gib den Namen deines Avatars ein: ");
            avatar = scan1.nextLine();

            while (unerlaubt) {
                if (avatar.contains("^")) {
                    unerlaubt = true;
                } else if (avatar.contains("°")) {
                    unerlaubt = true;
                } else if (avatar.contains("!")) {
                    unerlaubt = true;
                } else if (avatar.contains("²")) {
                    unerlaubt = true;
                } else if (avatar.contains("§")) {
                    unerlaubt = true;
                } else if (avatar.contains("³")) {
                    unerlaubt = true;
                } else if (avatar.contains("$")) {
                    unerlaubt = true;
                } else if (avatar.contains("%")) {
                    unerlaubt = true;
                } else if (avatar.contains("&")) {
                    unerlaubt = true;
                } else if (avatar.contains("/")) {
                    unerlaubt = true;
                } else if (avatar.contains("{")) {
                    unerlaubt = true;
                } else if (avatar.contains("(")) {
                    unerlaubt = true;
                } else if (avatar.contains("[")) {
                    unerlaubt = true;
                } else if (avatar.contains(")")) {
                    unerlaubt = true;
                } else if (avatar.contains("]")) {
                    unerlaubt = true;
                } else if (avatar.contains("=")) {
                    unerlaubt = true;
                } else if (avatar.contains("}")) {
                    unerlaubt = true;
                } else if (avatar.contains("?")) {
                    unerlaubt = true;
                } else if (avatar.contains("\\")) {
                    unerlaubt = true;
                } else if (avatar.contains("´")) {
                    unerlaubt = true;
                } else if (avatar.contains("`")) {
                    unerlaubt = true;
                } else if (avatar.contains("+")) {
                    unerlaubt = true;
                } else if (avatar.contains("*")) {
                    unerlaubt = true;
                } else if (avatar.contains("#")) {
                    unerlaubt = true;
                } else if (avatar.contains("'")) {
                    unerlaubt = true;
                } else if (avatar.contains(":")) {
                    unerlaubt = true;
                } else if (avatar.contains(";")) {
                    unerlaubt = true;
                } else if (avatar.contains(",")) {
                    unerlaubt = true;
                } else if (avatar.contains("<")) {
                    unerlaubt = true;
                } else if (avatar.contains(">")) {
                    unerlaubt = true;
                } else if (avatar.contains("|")) {
                    unerlaubt = true;
                } else if (avatar.contains("@")) {
                    unerlaubt = true;
                } else if (avatar.contains("€")) {
                    unerlaubt = true;
                } else if (avatar.contains("µ")) {
                    unerlaubt = true;
                } else if (avatar.contains("\"")) {
                    unerlaubt = true;
                } else if (avatar.contains(" ")) {
                    unerlaubt = true;
                } else {
                    unerlaubt = false;
                }
                if (unerlaubt) {
                    System.out.println("Der Name " + avatar + " enthält ungültige Zeichen. Bitte erneut eingeben: ");
                    avatar = scan1.nextLine();
                }
            }
            System.out.println("Dein Name lautet: " + avatar + " Speichern (1) oder neu eingeben (2)?");
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

// Spielfeld anlegen mit vorher abgefragter Roboterposition

        String[][] board = {{"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}};

        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);
        boolean position = true;
        int robox;
        int roboy;
        System.out.println("Auf welcher X-Position (1-15) möchtest du mit deinem Roboter starten?");
        robox = scan3.nextInt() - 1;
        System.out.println("Auf welcher Y-Position (1-10) möchtest du mit deinem Roboter starten?");
        roboy = scan4.nextInt() - 1;

        while (position) {
            if (robox < 0 || robox > 14 || roboy < 0 || roboy > 9) {
                position = true;
                System.out.println("Mindestens eine Koordinate befindet sich außerhalb des Spieldfeldes. Bitte erneut eingeben.");
                System.out.println("Auf welcher X-Position (1-15) möchtest du mit deinem Roboter starten?");
                robox = scan3.nextInt() - 1;
                System.out.println("Auf welcher Y-Position (1-10) möchtest du mit deinem Roboter starten?");
                roboy = scan4.nextInt() - 1;
            } else {
                position = false;
            }
        }
        board[roboy][robox] = "[Ö]";
        printSpielfeld(board);

        for (int i = 0; i < 100; i++) {
            int[] neuePosition = spielzug(board, robox, roboy);
            robox = neuePosition[0];
            roboy = neuePosition[1];
            printSpielfeld(board);
        }
/*
// Roboterposition ausgeben

        System.out.println("Der Roboter befindet sich in X=" + robox + " Y=" + roboy);
 */
    }
}