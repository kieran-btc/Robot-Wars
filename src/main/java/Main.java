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

// Spielfeld anlegen

        int x = 1;
        int y = 0;

        while (y <= 14) {
            while (x <= 14) {
                System.out.print("[]");
                x = x + 1;
                TimeUnit.MILLISECONDS.sleep(20);
            }
            x = 0;
            System.out.println("[]");
            x = x + 1;
            y = y + 1;
            TimeUnit.MILLISECONDS.sleep(20);
        }

    }
}