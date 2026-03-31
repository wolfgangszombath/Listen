package club.personen;

import club.personen.controller.CSVController;
import club.personen.model.Besucher;
import club.personen.view.ConsoleView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import java.time.LocalDate;
import java.util.List;

public class ManagementApp {
    public static void main(String[] args) {
        CSVController controller = new CSVController();
        ConsoleView view = new ConsoleView();

        try {
            // Daten initial laden
            List<Besucher> besucherListe = controller.leseBesucher();
            List<Mitarbeiter> mitarbeiterListe = controller.leseMitarbeiter();

            boolean läuft = true;
            while (läuft) {
                int wahl = view.zeigeMenue();

                switch (wahl) {
                    case 1 -> view.zeigeBesucher(besucherListe);
                    case 2 -> view.zeigeMitarbeiter(mitarbeiterListe);
                    case 3 -> {
                        String[] d = view.abfrageBesucher();
                        besucherListe.add(new Besucher(d[0], d[1], d[2]));
                        view.meldung("Besucher vorläufig hinzugefügt.");
                    }
                    case 4 -> {
                        String[] d = view.abfrageMitarbeiter();
                        mitarbeiterListe.add(new Mitarbeiter(d[0], d[1],
                                LocalDate.parse(d[2]), Double.parseDouble(d[3])));
                        view.meldung("Mitarbeiter vorläufig hinzugefügt.");
                    }
                    case 5 -> {
                        controller.schreibeBesucher(besucherListe);
                        controller.schreibeMitarbeiter(mitarbeiterListe);
                        view.meldung("Daten gespeichert. Auf Wiedersehen!");
                        läuft = false;
                    }
                    default -> view.meldung("Ungültige Auswahl!");
                }
            }
        } catch (Exception e) {
            view.meldung("Ein Fehler ist aufgetreten: " + e.getMessage());
        }
    }
}
