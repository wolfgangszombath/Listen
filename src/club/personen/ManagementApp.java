package club.personen;

import club.personen.controller.CSVController;
import club.personen.model.Besucher;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ManagementApp {
    public static void main(String[] args) {
        CSVController controller = new CSVController();

        try {
            // 1. Daten einlesen
            List<Besucher> besucherListe = controller.leseBesucher();
            List<Mitarbeiter> mitarbeiterListe = controller.leseMitarbeiter();

            // 2. Ausgabe (View-Part)
            System.out.println("Aktuelle Besucher:");
            besucherListe.forEach(System.out::println);

            System.out.println("\nAktuelle Mitarbeiter:");
            mitarbeiterListe.forEach(System.out::println);

            // 3. Daten manipulieren (z.B. neuen Mitarbeiter hinzufügen)
            mitarbeiterListe.add(new Mitarbeiter("Mustermann", "Max", LocalDate.of(1990, 1, 1), 4500.0));

            // 4. Daten speichern
            controller.schreibeBesucher(besucherListe);
            controller.schreibeMitarbeiter(mitarbeiterListe);
            System.out.println("\nDaten wurden erfolgreich in die CSV-Dateien geschrieben.");

        } catch (IOException e) {
            System.err.println("Dateifehler: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }
}