import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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

    }
}