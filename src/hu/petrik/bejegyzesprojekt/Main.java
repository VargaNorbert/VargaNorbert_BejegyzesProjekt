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

        tartalomModositasa();

        kiir(bejegyzesek);

        legnepszerubb();

        harminotLikeFolott();

        tizenotAlatt();


        rendezes();
        kiir(bejegyzesek);


    }

    private static void rendezes() {
        int n = bejegyzesek.size();


        for (int i = n - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (bejegyzesek.get(j).getLikeok() < bejegyzesek.get(j + 1).getLikeok()) {

                    Bejegyzes a = bejegyzesek.get(j);

                    bejegyzesek.set(j, bejegyzesek.get(j + 1));

                    bejegyzesek.set((j + 1), a);
                }
    }

    private static void kiir(List lista) {
        for (int i = 0; i < lista.size(); i++) {

            System.out.println(lista.get(i));
        }
    }

    private static void tizenotAlatt() {
        int a = 0;

        for (int i = 0; i < bejegyzesek.size(); i++) {

            if (bejegyzesek.get(i).getLikeok() < 15) {
                a++;
            }
        }

        System.out.printf("%d. db elem van ami 15-nél kevesebb like-al rendelkezik.\n", a);
    }

    private static void harminotLikeFolott() {
        boolean van = false;

        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > 35) {
                van = true;
            }
        }

        if (van == true) {
            System.out.println("Van olyan bejegyzés ami 35-nél több likeot kapott.");
        } else {
            System.out.println("Nincs olyan bejegyzés ami 35-nél több likeot kapott.");
        }
    }

    private static void legnepszerubb() {
        int max = 0;

        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > max) {
                max = bejegyzesek.get(i).getLikeok();
            }
        }

        System.out.println(max);
    }

    private static void tartalomModositasa() {
        Scanner sc = new Scanner(System.in);
        String tartalom;

        System.out.println("Mi legyen a masodik elem tartalma?");
        tartalom = sc.nextLine();

        bejegyzesek.get(1).setTartalom(tartalom);
    }

    private static void likeokKiosztása() {

        int a = bejegyzesek.size() * 20;

        Random r = new Random();

        for (int i = 0; i < a; i++) {
            bejegyzesek.get(r.nextInt(bejegyzesek.size())).like();
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
