package club.personen.controller;

import club.personen.model.Besucher;
import club.personen.Mitarbeiter;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVController {
    private final String BESUCHER_FILE = "besucher.csv";
    private final String MITARBEITER_FILE = "mitarbeiter.csv";

    // --- LESEN ---
    public List<Besucher> leseBesucher() throws IOException {
        List<Besucher> liste = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BESUCHER_FILE))) {
            String zeile;
            while ((zeile = br.readLine()) != null) {
                String[] d = zeile.split(",");
                if (d.length == 3) liste.add(new Besucher(d[0], d[1], d[2]));
            }
        }
        return liste;
    }

    public List<Mitarbeiter> leseMitarbeiter() throws IOException {
        List<Mitarbeiter> liste = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(MITARBEITER_FILE))) {
            String zeile;
            while ((zeile = br.readLine()) != null) {
                String[] d = zeile.split(",");
                if (d.length == 4) {
                    liste.add(new Mitarbeiter(d[0], d[1], LocalDate.parse(d[2]), Double.parseDouble(d[3])));
                }
            }
        }
        return liste;
    }

    // --- SCHREIBEN ---
    public void schreibeBesucher(List<Besucher> liste) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(BESUCHER_FILE))) {
            for (Besucher b : liste) pw.println(b.toCsvString());
        }
    }

    public void schreibeMitarbeiter(List<Mitarbeiter> liste) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(MITARBEITER_FILE))) {
            for (Mitarbeiter m : liste) pw.println(m.toCsvString());
        }
    }
}
