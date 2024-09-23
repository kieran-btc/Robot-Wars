import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

// Intro mit ASCII-Art und Willkommensnachricht

        System.out.println("     +------------+");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("     |  [|||||||]  |");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("     |  WELCOME TO |");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("     | ROBOT-WARS! |");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("     +------------+");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("        ||    ||");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("       //      \\");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("      //        \\");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("     []          []");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("    /||\0        /||\0");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("   / || \\      / || \\");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("  [  ||  ]    [  ||  ]");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("     ||          ||");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("    [__]        [__]");

// Avatar-Name anlegen

        String avatar;
        int bestätigung;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        System.out.println("Bitte gib den Namen deines Avatars ein: ");
        avatar = scan1.nextLine();
        System.out.println("Der Name deines Avatars lautet: " + avatar + " Bestätigen (1) oder neu eingeben (2)");
        bestätigung = scan2.nextInt();

        while (bestätigung != 1)

            if (bestätigung == 2) {
                System.out.println("Bitte gib den Namen deines Avatars ein: ");
                avatar = scan1.nextLine();
                System.out.println("Der Name deines Avatars lautet: " + avatar + " Bestätigen (1) oder neu eingeben (2)");
                bestätigung = scan2.nextInt();
            } else {
                System.out.println("Ungültig");
                bestätigung = 2;
            }

        System.out.println("Der Name wurde gespeichert!");

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