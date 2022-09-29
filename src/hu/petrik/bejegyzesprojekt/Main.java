package hu.petrik.bejegyzesprojekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {

    static List<Bejegyzes> bejegyzesek = new ArrayList<>();

    public static void main(String[] args) {

        Bejegyzes b1 = new Bejegyzes("Varga Norbert", "Megbukom");
        Bejegyzes b2 = new Bejegyzes("Gipsz Jakab", "Teszt");

        bejegyzesek.add(b1);
        bejegyzesek.add(b2);

        try {
            bejegyzesFelveteleKonzolrol();
        } catch (InputMismatchException e) {
            System.out.println("Nem megfelelő példány!");
        }

        try {
            beolvas("bejegyzesek.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Hiba a beolvasásnál");
        } catch (IOException e) {
            System.out.println("Ismeretlen hiba");
        }

        likeokKiosztása();


    }

    private static void likeokKiosztása(){

        int a = bejegyzesek.size()*20;

        Random r = new Random();

        for (int i = 0; i < a; i++) {
            bejegyzesek.get(r.nextInt(bejegyzesek.size() - 1)).like();
        }

    }

    private static void beolvas(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] adatok = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);

            bejegyzesek.add(bejegyzes);
            sor = br.readLine();

        }
        fr.close();
        br.close();
    }


    private static void bejegyzesFelveteleKonzolrol() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hány elemet szeretnél felvenni?");
        int a = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < a; i++) {
            System.out.printf("%d. elem  szerzője?", i + 1);
            String szerzo = sc.nextLine();

            System.out.printf("%d. elem tartalma?", i + 1);
            String tartalom = sc.nextLine();

            Bejegyzes bejegyzes = new Bejegyzes(szerzo, tartalom);

            bejegyzesek.add(bejegyzes);

        }

    }
}
