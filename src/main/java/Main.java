import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
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
        boolean unerlaubt = true;

//        while (bestätigung != 1) {
//
//            if (bestätigung == 2) {
//                System.out.println("Bitte gib den Namen deines Avatars ein: ");
//                avatar = scan1.nextLine();
//                System.out.println("Der Name deines Avatars lautet: " + avatar + " Bestätigen (1) oder neu eingeben (2)");
//                bestätigung = scan2.nextInt();
//            } else {
//                System.out.println("Ungültig");
//                bestätigung = 2;
//            }
//        }

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

            System.out.println("Dein Name wurde gespeichert! Er lautet: " + avatar);

// Spielfeld anlegen mit vorher abgefragter Roboterposition

            Scanner scan3 = new Scanner(System.in);
            Scanner scan4 = new Scanner(System.in);

            System.out.println("Auf welcher X-Position (1-15) möchtest du mit deinem Roboter starten?");
            int robox = scan3.nextInt();
            System.out.println("Auf welcher Y-Position (1-10) möchtest du mit deinem Roboter starten?");
            int roboy = scan4.nextInt();

            int x = 1;
            int y = 1;

            while (y <= 10) {            // Höhe 10
                x = 1;
                while (x <= 15) {        // Breite 15
                    if (x == robox && y == roboy) {
                        System.out.print("{Ö}");
                        x++;
                    } else {
                        System.out.print("[ ]");
                        x++;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                }
                System.out.println();
                y++;
                TimeUnit.MILLISECONDS.sleep(10);
            }

// Roboterposition ausgeben

            System.out.println("Der Roboter befindet sich in X=" + robox + " Y=" + roboy);
        }
    }