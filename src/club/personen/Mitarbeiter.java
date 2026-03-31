package club.personen;
import club.personen.model.Person;

import java.time.LocalDate;

public class Mitarbeiter extends Person {
    private LocalDate geburtsdatum;
    private double gehalt;

    public Mitarbeiter(String name, String vorname, LocalDate geburtsdatum, double gehalt) {
        super(name, vorname);
        this.geburtsdatum = geburtsdatum;
        this.gehalt = gehalt;
    }

    @Override
    public String toCsvString() {
        return name + "," + vorname + "," + geburtsdatum + "," + gehalt;
    }

    @Override
    public String toString() {
        return String.format("Mitarbeiter: %s %s (Geb: %s, Gehalt: %.2f)", vorname, name, geburtsdatum, gehalt);
    }
}
