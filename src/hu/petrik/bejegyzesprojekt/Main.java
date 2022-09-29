package hu.petrik.bejegyzesprojekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzesek = new ArrayList<>();

    public static void main(String[] args) {

        try {
            bejegyzesFelveteleKonzolrol();
        } catch (Exception e) {
            System.out.println("Nem megfelelő példány!");
        }






    }





    private static void bejegyzesFelveteleKonzolrol() {
    Scanner sc = new Scanner(System.in);

        System.out.println("Hány elemet szeretnél felvenni?");
        int a = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i<a;i++) {
        System.out.printf("%d. elem  szerzője?",i+1);
        String szerzo = sc.nextLine();

        System.out.printf("%d. elem tartalma?",i+1);
        String tartalom = sc.nextLine();

        Bejegyzes bejegyzes= new Bejegyzes(szerzo,tartalom);

        bejegyzesek.add(bejegyzes);

        }

    }
}
