package exercitiul1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAppex1 {
    static List<Echipament> echipamente = new ArrayList<>();

    public static void citesteEchipamente(String fisier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fisier));
        String s;
        while ((s = reader.readLine()) != null) {
            String[] info = s.split(";");
            switch (info[5].toLowerCase()) {
                case "imprimanta":
                    String rezolutie = info[7].replaceAll("[^0-9x]", "");
                    echipamente.add(new Imprimanta(info[0], Integer.parseInt(info[1]), Double.parseDouble(info[2]), info[3], Stare.valueOf(info[4].toLowerCase()), Integer.parseInt(info[6]), rezolutie, Integer.parseInt(info[8]), Mod.valueOf(info[9].toLowerCase())));
                    break;
                case "copiator":
                    echipamente.add(new Copiator(info[0], Integer.parseInt(info[1]), Double.parseDouble(info[2]), info[3], Stare.valueOf(info[4].toLowerCase()), Integer.parseInt(info[6]), Format.valueOf(info[7].toUpperCase())));
                    break;
                case "sistem de calcul":
                    echipamente.add(new SistemDeCalcul(info[0], Integer.parseInt(info[1]), Double.parseDouble(info[2]), info[3], Stare.valueOf(info[4].toLowerCase()), info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8]), Sistem.valueOf(info[9].toLowerCase())));
                    break;
            }
        }
        reader.close();
    }

    public static void afiseazaEchipamente() {
        for (Echipament e : echipamente) {
            System.out.println(e);
        }
    }

    public static void serializeaza(String fisier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fisier))) {
            oos.writeObject(echipamente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeaza(String fisier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fisier))) {
            echipamente = (List<Echipament>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void modificaStare(String nume, Stare stareNoua) {
        for (Echipament e : echipamente) {
            if (e.getDenumire().equalsIgnoreCase(nume)) {
                e.setStare(stareNoua);
                System.out.println("Starea echipamentului a fost modificată.");
                return;
            }
        }
        System.out.println("Echipamentul cu numele " + nume + " nu a fost găsit.");
    }

    public static void main(String[] args) throws IOException {
        citesteEchipamente("src/exercitiul1/electrocasnice.txt");
        Scanner scanner = new Scanner(System.in);
        int optiune;
        do {
            System.out.println("\n1. Afișarea echipamentelor");
            System.out.println("2. Modificare stare echipament");
            System.out.println("3. Serializare");
            System.out.println("4. Deserializare");
            System.out.println("0. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    afiseazaEchipamente();
                    break;
                case 2:
                    System.out.print("Introduceți numele echipamentului: ");
                    String nume = scanner.nextLine();
                    System.out.print("Introduceți noua stare (achizitionat/expus/vandut): ");
                    Stare stareNoua = Stare.valueOf(scanner.nextLine().toLowerCase());
                    modificaStare(nume, stareNoua);
                    break;
                case 3:
                    serializeaza("echipamente.bin");
                    System.out.println("Echipamentele au fost serializate în 'echipamente.bin'.");
                    break;
                case 4:
                    deserializeaza("echipamente.bin");
                    System.out.println("Echipamentele au fost deserializate din 'echipamente.bin'.");
                    break;
                case 0:
                    System.out.println("Ieșire din program.");
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        } while (optiune != 0);

        scanner.close();
    }
}
