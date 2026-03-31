package club.personen.model;

public class Besucher extends Person {
    private String art;

    public Besucher(String name, String vorname, String art) {
        super(name, vorname);
        this.art = art;
    }

    @Override
    public String toCsvString() {
        return name + "," + vorname + "," + art;
    }

    @Override
    public String toString() {
        return String.format("Besucher: %s %s (Typ: %s)", vorname, name, art);
    }
}
