package club.personen.view;

import club.personen.Mitarbeiter;
import club.personen.model.Besucher;

import java.util.Scanner;
import java.util.List;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public int zeigeMenue() {
        System.out.println("\n--- VERWALTUNGSSYSTEM ---");
        System.out.println("1. Besucher anzeigen");
        System.out.println("2. Mitarbeiter anzeigen");
        System.out.println("3. Neuen Besucher hinzufügen");
        System.out.println("4. Neuen Mitarbeiter hinzufügen");
        System.out.println("5. Speichern & Beenden");
        System.out.print("Auswahl: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void zeigeBesucher(List<Besucher> liste) {
        System.out.println("\n--- BESUCHERLISTE ---");
        liste.forEach(System.out::println);
    }

    public void zeigeMitarbeiter(List<Mitarbeiter> liste) {
        System.out.println("\n--- MITARBEITERLISTE ---");
        liste.forEach(System.out::println);
    }

    public String[] abfrageBesucher() {
        System.out.print("Nachname: "); String n = scanner.nextLine();
        System.out.print("Vorname: "); String v = scanner.nextLine();
        System.out.print("Art (VIP/Standard/Student): "); String a = scanner.nextLine();
        return new String[]{n, v, a};
    }

    public String[] abfrageMitarbeiter() {
        System.out.print("Nachname: "); String n = scanner.nextLine();
        System.out.print("Vorname: "); String v = scanner.nextLine();
        System.out.print("Geburtsdatum (YYYY-MM-DD): "); String d = scanner.nextLine();
        System.out.print("Gehalt: "); String g = scanner.nextLine();
        return new String[]{n, v, d, g};
    }

    public void meldung(String msg) {
        System.out.println(">> " + msg);
    }
}
