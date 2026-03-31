package club.personen.model;
import java.time.LocalDate;

// Oberklasse
public abstract class Person {
    protected String name;
    protected String vorname;

    public Person(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    // Abstrakte Methode, damit jede Unterklasse weiß, wie sie sich in CSV schreibt
    public abstract String toCsvString();
}
